package tpIntra;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private static List<Alumno> listaAlumnos;
    private static List<Comision> listaComisiones;
    private static List<Materia> listaMaterias;
    private static List<CicloLectivo> listaCiclosLectivos;
    private static List<Profesor> listaProfesores;

    public Universidad() {
        listaAlumnos = new ArrayList<>();
        listaMaterias = new ArrayList<>();
        listaComisiones = new ArrayList<>();
        listaCiclosLectivos = new ArrayList<>();
        listaProfesores = new ArrayList<>();
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
    
    public CicloLectivo buscarCicloLectivo(CicloLectivo buscado) {
    	for (CicloLectivo cl : listaCiclosLectivos) {
			if(cl.equals(buscado)) {
				return cl;
			}
		}
    	
    	return null;
    }
    
    public Comision buscarComision(Comision buscado) {
    	
    	for (Comision c : listaComisiones) {
			if(c.getCodigo().equals(buscado.getCodigo())) {
				return c;
			}
		}
    	
    	return null;
    }
    
    public Boolean asignarCicloLectivoAComision(Comision comisionAsignada, CicloLectivo cicloAsignar) {
    	
    	if(buscarCicloLectivo(cicloAsignar) != null && buscarComision(comisionAsignada) != null) {
    		buscarComision(comisionAsignada).setCicloPerteneciente(cicloAsignar);
    		return true;
    	}
    	
    	return false;
    	
    	
    	
    }
    public boolean agregarComision(Comision comision) {
        // Verifica si ya existe una comisión con el mismo código
        if(listaComisiones == null) {
        	return listaComisiones.add(comision);
        }else {
    	
    	for (Comision c : listaComisiones) {
            	if (c.getCodigo().equals(comision.getCodigo())) {
                	return false; // El código de comisión ya existe
            	}
            
            	if(c.getMateriaAsignada().equals(comision.getMateriaAsignada())) {
            		return false;
            	}
            
            	if(c.getCicloPerteneciente().equals(comision.getCicloPerteneciente())) {
            		return false;
            	}
            
            	if(c.getTurno().equals(comision.getTurno())) {
            		return false;
            	}
        	}
    	return listaComisiones.add(comision);
        
        }
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
    
    public Boolean agregarCicloLectivo(CicloLectivo cicloAgregar) {
    	
    	if(listaCiclosLectivos == null) {
    		return listaCiclosLectivos.add(cicloAgregar);
    	}else {
    		//Verifica si el cilcoLectivo ya existe (si tiene el mismo id)
    		
    		for (CicloLectivo cl : listaCiclosLectivos) {
    			
    			if(cl.equals(cicloAgregar)) {
    				return false;
    			}
    			//Verifica que las fecha de inicio o final no coincidan.
    			if(cl.getFechaInicio().isEqual(cicloAgregar.getFechaInicio()) || cl.getFechaFin().isEqual(cicloAgregar.getFechaFin())) {
    				return false;
    			}
    			
    			if(cicloAgregar.getFechaInicio().isBefore(cl.getFechaFin()) &&
                cicloAgregar.getFechaFin().isAfter(cl.getFechaInicio())) {
    				return false;
    			}
			}
    		//Si todo lo anterior no ocurre se agrega a la lista.
    		
    		return listaCiclosLectivos.add(cicloAgregar);
    	}
    	
    }
    public Boolean agregarDocentes(Profesor nuevoProfesor) {
		
    	if(listaProfesores == null) {
    		return listaProfesores.add(nuevoProfesor);
    	}else {
    		for (Profesor p : listaProfesores) {
				
    			if(p.getDni() == nuevoProfesor.getDni()) {
    				return false;
    			}
    			
			}
    		
    		return listaProfesores.add(nuevoProfesor);
    	}
    	
	}
    
    public Boolean asignarDocentesAComision(Profesor profesorAsignar, Comision comisionDondeSeAsigna) {
    	
    	if(!profesorAlta(profesorAsignar) || !comisionAlta(comisionDondeSeAsigna)) {
    		return false;
    	}else {
    		
    		for (Comision c : listaComisiones) {
				
    			if(c.getProfesores() == null) {
    				c.agregarProfesor(profesorAsignar);
    			}else {
    				if(c.getProfesores().contains(profesorAsignar)) {
    					return false;
    				}else {
    					c.agregarProfesor(profesorAsignar);
    				}
    			}
			}
    		
    		return true;
    		
    		
    		
    	}
    	
    	
    }
    
    private Boolean comisionAlta(Comision comisionDondeSeAsigna) {
		// TODO Auto-generated method stub
		return listaComisiones.contains(comisionDondeSeAsigna);
	}

	private Boolean profesorAlta(Profesor profesorAsignar) {
		// TODO Auto-generated method stub
		return listaProfesores.contains(profesorAsignar);
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

	public static List<CicloLectivo> getListaCiclosLectivos() {
		return listaCiclosLectivos;
	}

	public static List<Profesor> getListaProfesores() {
		return listaProfesores;
	}

	

	
	

}