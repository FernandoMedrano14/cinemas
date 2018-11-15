<%-- 
    Document   : reporte
    Created on : 09-nov-2018, 16:34:03
    Author     : fernando.medranousam
--%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.util.JRLoader"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte</title>
    </head>
    <body>
        
        <% 
        response.setHeader("Cache-control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("application/pdf");
        
        try{
            String url = "./cines.jasper";
            System.out.println("URL: "+url);
            //ServletOutputStream salida = response.getOutputStream();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinemas", "root", "root");
            if(conn!=null){
                System.out.println("SE CONECTO CON EXITO");
            }
            Map parametro = new HashMap();
            parametro.put("id", Integer.parseInt("1"));
            //JasperReport reporte = (JasperReport) JRLoader.loadObject("cines.jasper");
            JasperPrint informe = JasperFillManager.fillReport(url, parametro,conn);
            JasperViewer.viewReport(informe,false);
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        %>
        
    </body>
</html>
