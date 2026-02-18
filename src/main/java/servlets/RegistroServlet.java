/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import models.Usuario;
import repositorios.UsuarioDB;

/**
 *
 * @author janethcristinagalvanquinonez
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/registro"})
public class RegistroServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        String nombre= request.getParameter("txt_name");
        String correo= request.getParameter("txt_email");
        String contrasenia= request.getParameter("txt_password");
        String pseudonimo= request.getParameter("txt_pseudonimo");
        String estado= request.getParameter("txt_estado");
        String tipoCuenta= request.getParameter("sel_cuenta");
        String fechaNacimientoStr= request.getParameter("txt_fecha_nacimiento");
        String terminos= request.getParameter("chk_terminos");  
        
        if(nombre == null || correo == null){
            response.sendRedirect("error.html");
            return;
        }
        
        if(UsuarioDB.existeCorreo(correo)){
            response.sendRedirect("error.html");
        }
        
        LocalDate fechaNacimiento= LocalDate.parse(fechaNacimientoStr);
        boolean aceptoTerminos= terminos.equals("aceptado");
        
        Usuario usuario= new Usuario(nombre, correo, contrasenia, pseudonimo, estado, tipoCuenta,fechaNacimiento, aceptoTerminos);
        UsuarioDB.registrar(usuario);
        
        response.sendRedirect("iniciar-sesion.html");
        
        
        
    }

}
