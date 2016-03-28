package preportes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.SimpleFileResolver;

/**
 *
 * @author DILOVE
 */
public class ReporteProducto1 extends HttpServlet {
    
    public void ejecutarReporte(HttpServletRequest request, HttpServletResponse response, String tipo) throws JRException {
        Connection conn = null;

        try {
            
            //Se consulta la ruta del reporte
            String rutaReportes = this.getServletContext().getRealPath("/reporte");
            String rutaReporte = "/ReporteProducto.jasper";
            
            String rutaCompleta = rutaReportes + rutaReporte;
            //System.out.println("Ruta completa: "+rutaCompleta);

            List<File> parentFolders = new ArrayList();
            parentFolders.add(new File(rutaReportes));
            
           Map params = new HashMap();
            params.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(parentFolders));
                    
            //Se abre el reporte
            InputStream inputStream = new FileInputStream(rutaCompleta);

            if (inputStream == null) {
                throw new ClassNotFoundException("Archivo .jasper no se encontro");
            }

            JRExporter exporter = null;
            
            //Se abre la cx
            Context initContext = new InitialContext();            
            DataSource ds = (DataSource)initContext.lookup("bdproyecto");
            conn = ds.getConnection();
            //System.out.println("Conexion: "+conn.getCatalog());
            //Se llena el reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, null, conn);

            //Se escribe en el flujo de datos de salida
            ServletOutputStream out = null;

            response.setContentType(tipo);
            if ("application/pdf".equals(tipo)) {
                response.setHeader("Content-disposition", "attachment; filename=\"Producto.pdf\""); // The Save As popup magic is done here. You can give it any filename you want, this only won't work in MSIE, it will use current request URL as filename instead.
                out = response.getOutputStream();
                exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
                
            } 
            if (exporter != null) {
                exporter.exportReport();
            }

            if (out != null) {
                out.close();
            }

        } catch (Exception e) {
            Logger.getLogger(ReporteProducto1.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(ReporteProducto1.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ejecutarReporte(request, response, "application/pdf");
        } catch (JRException ex) {
            Logger.getLogger(ReporteProducto1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ejecutarReporte(request, response, "application/pdf");
        } catch (JRException ex) {
            Logger.getLogger(ReporteProducto1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
