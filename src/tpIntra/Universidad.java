package tpIntra;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private static List<Alumno> listaAlumnos;
    private static List<Comision> listaComisiones = new ArrayList<>();
    private static List<Materia> listaMaterias;

    public Universidad() {
        listaAlumnos = new ArrayList<>();
        listaMaterias = new ArrayList<>();
    }

    public boolean agregarAlumno(Alumno alumno) {
        // Verifica si ya existe un alumno con el mismo DNI
        for (Alumno a : listaAlumnos) {
            if (a.getDni().equals(alumno.getDni())) {
                return false; // El DNI ya existe, a ksa pete
            }
        }
        
        // Si el DNI no existe en la lista, agregar al alumno
        listaAlumnos.add(alumno);
        return true;
    }
    
    public boolean agregarComision(Comision comision) {
        // Verifica si ya existe una comisión con el mismo código
        for (Comision c : listaComisiones) {
            if (c.getCodigo().equals(comision.getCodigo())) {
                return false; // El código de comisión ya existe
            }
        }

        // Si el código no existe en la lista, agregar la comisión
        listaComisiones.add(comision);
        return true;
    }

    
    public Boolean agregarMateria(Materia materiaAgregada) {
    	
    	//No se puede agregar 2 materias con mismo Id
    	
    	if(listaMaterias == null) {
    		return listaMaterias.add(materiaAgregada);
    	}else {    	
    		for (Materia materia : listaMaterias) {
    			
    			if(materia.equals(materiaAgregada)) {
					return false;
				}
			}
    		
    		return listaMaterias.add(materiaAgregada);
    	}
    }

    public Boolean agregarCorrelatividad(Integer id, Integer id2) {
		
		for (Materia m : listaMaterias) {
			if(m.getId().equals(id)) {
				//Solo permite el agregado de correlativas si no tiene ninguna asignada.
				if(m.getIdCorrelativa() == null) { 
				m.setIdCorrelativa(id2);
				return true;
				}
				
			}
		}
		return false;
	}
    
    public Boolean eliminarCorrelatividad(Integer id, Integer id2) {
		
    	for (Materia m : listaMaterias) {
			if(m.getId().equals(id)) {
				//Estos condicionales verifican que tenga correlativas y correspondan al valor buscado.
				if(m.getIdCorrelativa() != null) { 
					if(m.getIdCorrelativa().equals(id2)) {
						m.setIdCorrelativa(null);
						return true;
					}
					
				}
				
			}
		
    	}
    	
    	return false;
		
	}

    
    public static List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public static List<Comision> getListaComisiones() {
        return listaComisiones;
    }
    
    public static List<Materia> getListaMaterias(){
    	return listaMaterias;
    }

	
	

}