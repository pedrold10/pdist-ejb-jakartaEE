package com.gugawag.pdist.servlets;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import calculadora.CalculadoraIF;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/calculadora.do"})
public class CalculadoraServlet extends HttpServlet {

    @EJB(lookup = "java:global/calculadoraejb-1.0-SNAPSHOT/calculadoraService")
    private CalculadoraIF calculadoraIF;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String n1 = request.getParameter("n1");
        String n2 = request.getParameter("n2");
        String operacao = request.getParameter("oper");
        PrintWriter resposta = response.getWriter();
        if(operacao.equals("somar")){
            resposta.println(calculadoraIF.somar(Integer.parseInt(n1), Integer.parseInt(n2)));
        }

    }
}
