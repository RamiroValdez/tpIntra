package tpIntra;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class Universidad {
	
    private List<Alumno> listaAlumnos = new ArrayList<>(); //Declarar como estática
    private List<Comision> listaComisiones = new ArrayList<>(); //Declarar como estática
    private List<CicloLectivo> listaCiclosLectivos = new ArrayList<>();
    private List<Materia> listaMaterias = new ArrayList<>(); 
    private List <Aula> aula = new ArrayList<>();

    public boolean agregarAlumno(Alumno alumno) {
        // Verifica si ya existe un alumno con el mismo DNI
        for (Alumno a : listaAlumnos) {
            if (a.getDni().equals(alumno.getDni())) {
                return false; // El DNI ya existe, no se puede agregar
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
                System.out.println("La comisión con código " + comision.getCodigo() + " ya existe en la lista.");
                return false; // El código de comisión ya existe
            }
        }

        // Si el código no existe en la lista, agregar la comisión
        listaComisiones.add(comision);
        System.out.println("Comisión con código " + comision.getCodigo() + " agregada correctamente.");
        return true;
    }

 
 	public Boolean agregarCicloLectivo(CicloLectivo ciclo) {
 		if(listaCiclosLectivos == null) {
 			return listaCiclosLectivos.add(ciclo);
 		}else {
 			for (CicloLectivo c : listaCiclosLectivos) {
				if(c.getIdCicloLectivo() == ciclo.getIdCicloLectivo()) {
					return false;
				}
			}
 			
 			return listaCiclosLectivos.add(ciclo);
 		}
 	}

 	public List<Alumno> getListaAlumnos() {
 	    return listaAlumnos;
 	}

    public List<Comision> getListaComisiones() {
        return listaComisiones;
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
    
    public Boolean asignarCorrelativdidad(Materia materiaAAsignar, Materia materiaAsignada) {

        if(!listaMaterias.contains(materiaAAsignar)) {
            return false;
        }
        if(!listaMaterias.contains(materiaAsignada)) {
            return false;
        }

        for (Materia m : listaMaterias) {
            if(m.getIdCorrelativa() == null) {
                if(m.getId().equals(materiaAAsignar.getId())) {
                    m.setIdCorrelativa(materiaAsignada.getId());
                }
            }
        }

        return true;

    }
    
    public Boolean agregarCorrelatividad(Integer id, Integer valorCorrelatividad) {
		
  		for (Materia m : listaMaterias) {
  			if(m.getId().equals(id)) {
  				//Solo permite el agregado de correlativas si no tiene ninguna asignada.
  				if(m.getIdCorrelativa() == null) { 
  				m.setIdCorrelativa(valorCorrelatividad);
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
      
      public boolean inscribirAlumnoAComision(Alumno alumno, Comision comision) {
          
      	// Verificar que el alumno y la comisión estén dados de alta
          if (!esAlumnoAlta(alumno) || !esComisionAlta(comision)) {
              return false;
          }

          // Verificar que el alumno tenga aprobadas todas las correlativas (4 o más)
          if (!tieneCorrelativasAprobadas(alumno)) {
              return false;
          }


          // Verificar que no se exceda la cantidad de alumnos permitidos en el aula
          if (excedeCapacidadAula(comision)) {
              return false;
          }

          // Verificar que el alumno no esté inscrito a otra comisión el mismo día y turno
          if (estaInscritoEnOtraComision(alumno, comision)) {
              return false;
          }

          // Verificar que el alumno no haya aprobado previamente la materia
          if (yaAproboMateria(alumno, comision)) {
              return false;
          }

          // Si todas las verificaciones pasan, inscribir al alumno a la comisión
          comision.agregarAlumno(alumno);
          return true;
      }
      private boolean tieneCorrelativasAprobadas(Alumno alumno) {
    	    // Supongamos que tienes una lista de correlativas aprobadas por el alumno
    	    List<Materia> correlativasAprobadas = alumno.getCorrelativasAprobadas();

    	    // Verificar si el alumno tiene al menos 4 correlativas aprobadas
    	    boolean tieneAprobadas = correlativasAprobadas.size() >= 4;


    	    return tieneAprobadas;
    	}

      private boolean esAlumnoAlta(Alumno alumno) {
    	    boolean esAlta = listaAlumnos.contains(alumno);
    	    return esAlta;
    	}

    	private boolean esComisionAlta(Comision comision) {
    	    boolean esAlta = listaComisiones.contains(comision);
    	    return esAlta;
    	}

    	
    	private boolean excedeCapacidadAula(Comision comision) {
    	    // Supongamos que tienes la capacidad máxima del aula de la comisión
    	    int capacidadMaximaAula = comision.getAula().getCapacidadMaxima();

    	    // Verificar si la cantidad de alumnos inscritos en la comisión excede la capacidad del aula
    	    boolean excedeCapacidad = comision.getAlumnos().size() >= capacidadMaximaAula;


    	    return excedeCapacidad;
    	}

    	private boolean estaInscritoEnOtraComision(Alumno alumno, Comision comision) {
    	    // Supongamos que tienes la lista de comisiones a las que el alumno está inscrito
    	    List<Comision> comisionesInscritas = alumno.getComisionesInscritas();

    	    // Supongamos que también tienes la información de día y turno de la comisión
    	    String diaComisionActual = comision.getDia();
    	    String turnoComisionActual = comision.getTurno();

    	    // Obtener el código único de la comisión actual
    	    String codigoComisionActual = comision.getCodigo();

    	    // Verificar si el alumno está inscrito en otra comisión el mismo día y turno
    	    for (Comision otraComision : comisionesInscritas) {
    	        // Comparar por igualdad de códigos en lugar de referencias
    	        boolean estaInscrito = !codigoComisionActual.equals(otraComision.getCodigo()) &&
    	                               diaComisionActual.equals(otraComision.getDia()) &&
    	                               turnoComisionActual.equals(otraComision.getTurno());

    	        if (estaInscrito) {
    	            return true;
    	        }
    	    }
    	    return false;
    	}

    	private boolean yaAproboMateria(Alumno alumno, Comision comision) {
    	    // Supongamos que tienes la lista de materias aprobadas por el alumno
    	    List<Materia> materiasAprobadas = alumno.getMateriasAprobadas();

    	    // Supongamos que también tienes la materia de la comisión
    	    Materia materiaComision = comision.getMateria();

    	    // Verificar si el alumno ya aprobó la materia de la comisión
    	    boolean yaAprobo = materiasAprobadas.contains(materiaComision);

    	    return yaAprobo;
    	}

	public List<CicloLectivo> getListaCiclosLectivos() {
		return listaCiclosLectivos;
	}

	public boolean asignarCicloAComision(Comision comision, CicloLectivo ciclo) {
		
		if(!listaComisiones.contains(comision)) {
			return false;
		}
		
		if(!listaCiclosLectivos.contains(ciclo)) {
			return false;
		}
		
		for (Comision c : listaComisiones) {
			if(c.getCodigo().equals(comision.getCodigo())) {
				c.setCicloActual(ciclo);
				break;
			}
		}
		
		return true;
	}
	
	public Integer buscarCorrelativa(Materia materia) {
		
		Integer valorBuscado = 0;
		if(esMateriaAlta(materia)) {
			
			for (Materia m : listaMaterias) {
				if(m.getId()==materia.getId()) {
					valorBuscado = m.getIdCorrelativa();
				}
			}
			
		}
		
		return valorBuscado;
		
	}


	
	public boolean registrarNota(Comision comision, Alumno alumno, Nota nota) {

				
        if(!esComisionAlta(comision)) {
        return false;
        }
        if(!esAlumnoAlta(alumno)) {
            return false;
        }
        if(nota.getValorNota()>= 7) {
        	if(saberSiTieneLasCorrelativasAprobadas(alumno, comision.getMateria().getIdCorrelativa())==false) {
        		return false;
        	}
        }
        if(buscarCorrelativa(comision.getMateria())!=null){
        	if(yaAproboMateria(alumno, comision)) {
        		
        	}
        }

        Boolean val = false;
        for (Comision co : listaComisiones) {
            if(co.getCodigo().equals(comision.getCodigo())) {

                val = co.registrarNota(new RegistroNotas(alumno,nota));

            }
        }

        return val;


    }
	
	public Boolean asignarMateriaAComision(Materia materia, Comision comision) {

        if(!esMateriaAlta(materia)) {
            return false;
        }

        if(!esComisionAlta(comision)) {
            return false;
        }

        for (Comision co : listaComisiones) {
            if(co.getCodigo().equals(comision.getCodigo())) {
                if(co.getMateria() == null) {
                    co.setMateria(materia);
                }
            }
        }

        return true;

    }
	
	private Boolean esMateriaAlta(Materia materia) {

        return listaMaterias.contains(materia);

    }
	
	public Nota obtenerNota(Alumno alumno, Materia materia) {
	    for (Comision comision : listaComisiones) {
	        if (comision.getAlumnos().contains(alumno) && comision.getMateria().equals(materia)) {
	            for (RegistroNotas registro : comision.getRegistrosNotas()) {
	                if (registro.getAlumno().equals(alumno) && registro.getNota() != null) {
	                    return registro.getNota();
	                }
	            } 
	        }
	    }
		return null;
	}
	
	public void setListaComisiones(List<Comision> listaComisiones) {
	    this.listaComisiones = listaComisiones;
	}

	public Boolean saberSiTieneLasCorrelativasAprobadas(Alumno alumno, Integer valorCorrelatividad) {
		
		Boolean validacion = true;
		
		if(!esAlumnoAlta(alumno)) {
			return false;
		}
		
		List<Materia> materiasCorrelativas = new ArrayList<>();
		
		for (Materia materia : listaMaterias) {
			if(materia.getIdCorrelativa() == valorCorrelatividad) {
				materiasCorrelativas.add(materia);
			}
		}
		
		for (Materia materia1 : materiasCorrelativas) {
			if(alumno.getMateriasAprobadas().contains(materia1)) {
				validacion = true;
			};
		}
		
		return validacion;
		
		
	}

}
