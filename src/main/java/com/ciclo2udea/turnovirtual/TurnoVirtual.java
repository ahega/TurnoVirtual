package com.ciclo2udea.turnovirtual;

import java.util.Arrays;

public class TurnoVirtual {
    //Atributos
    private String[] turnos;
    private String[] turnosPerdidos;
    private boolean estadoTurnoVirtual;
    private int turnoEnAtencion;
    private int cantidadTurnosAtendidos;
    
    //Metodo Constructor
    public TurnoVirtual(String [] turnos){
        this.turnos=turnos;
        this.turnosPerdidos=new String[turnos.length];
        for(int i=0;i<turnos.length;i++){
            turnosPerdidos[i]=" ";
        }
        this.estadoTurnoVirtual=true;
        this.turnoEnAtencion=0;
        this.cantidadTurnosAtendidos=1;
    }
    ///// Getters and Setters///////////
    public String[] getTurnos() {
        return turnos;
    }

    public void setTurnos(String[] turnos) {
        this.turnos = turnos;
    }

    public String[] getTurnosPerdidos() {
        return turnosPerdidos;
    }

    public void setTurnosPerdidos(String[] turnosPerdidos) {
        this.turnosPerdidos = turnosPerdidos;
    }

    public boolean isEstadoTurnoVirtual() {
        return estadoTurnoVirtual;
    }

    public void setEstadoTurnoVirtual(boolean estadoTurnoVirtual) {
        this.estadoTurnoVirtual = estadoTurnoVirtual;
    }

    public int getTurnoEnAtencion() {
        return turnoEnAtencion;
    }

    public void setTurnoEnAtencion(int turnoEnAtencion) {
        this.turnoEnAtencion = turnoEnAtencion;
    }

    public int getCantidadTurnosAtendidos() {
        return cantidadTurnosAtendidos;
    }

    public void setCantidadTurnosAtendidos(int cantidadTurnosAtendidos) {
        this.cantidadTurnosAtendidos = cantidadTurnosAtendidos;
    }
    ///End Getters and Setters///////////
    
    
    /// Metodo toString
    @Override
    public String toString() {
        return "TurnoVirtual{" + "turnos=" + Arrays.toString(turnos) + ", turnosPerdidos=" + Arrays.toString(turnosPerdidos) + ", estadoTurnoVirtual=" + estadoTurnoVirtual + ", turnoEnAtencion=" + turnoEnAtencion + ", cantidadTurnosAtendidos=" + cantidadTurnosAtendidos + '}';
    }
    
    public void atenderProximoTurno(){
        if(estadoTurnoVirtual==true){
            turnoEnAtencion=turnoEnAtencion+1;
            cantidadTurnosAtendidos=cantidadTurnosAtendidos+1;
        }
    
    }
    
    public void agregarTurnoPerdido() {
        for (int i = 0; i < turnosPerdidos.length; i++) {
            if (" ".equals(turnosPerdidos[i])) {
                turnosPerdidos[i] = turnos[turnoEnAtencion];
                break;
            }
        }
    } 
    
    public void cambiarEstadoTurno(){
        if(estadoTurnoVirtual==true){
            estadoTurnoVirtual=false;
        }
        else if(estadoTurnoVirtual==false){
            estadoTurnoVirtual=true;
        }
    }
  
    
    /// Main
    public static void main(String[] args) {
        String[] cola={"A0","A1","A2","A3","A4","A5","A6","A7","A8","A9","A10","A11"};
        TurnoVirtual turnoVirtual=new TurnoVirtual(cola);
        
        turnoVirtual.atenderProximoTurno();
        turnoVirtual.atenderProximoTurno();
        turnoVirtual.atenderProximoTurno();
        turnoVirtual.atenderProximoTurno();
        
        turnoVirtual.agregarTurnoPerdido();
        turnoVirtual.atenderProximoTurno();
        turnoVirtual.agregarTurnoPerdido();
        turnoVirtual.atenderProximoTurno();
        turnoVirtual.agregarTurnoPerdido();
        
        turnoVirtual.cambiarEstadoTurno();
        turnoVirtual.atenderProximoTurno();
        turnoVirtual.cambiarEstadoTurno();
        
        System.out.println("metodo tostring : ");
        System.out.println(turnoVirtual.toString());
        
    }

}
