const ulLists = document.querySelector(".ul-listas");

//Local Starage
var arregloTareas = [];
var contador = 0;

const AddTask = async () => {

  ulLists.addEventListener("click", (event) => {
    //método para agregar una tarea
    if(event.path[0].type == "button"){
      if(event.path[0].classList.value == "boton-agregar"){
        agregarTarea(event, 1, "");
      }
    }
  });

  // botonLimpiar.addEventListener("click", () => {
  //   //método Limpiar
  //   limpiarTodo();
  // });

  ulLists.addEventListener("click", (event) => {
    //método para eliminar una tarea
    if (event.path[0].type == "button") {
      if(event.path[0].classList.value == "boton-eliminar btn-dark"){
        eliminarTarea(event, 2, event.path[1].id);
      }
    }
  });

  // listaTarea.addEventListener("keypress", (event) => {
  //   //método editar
  //   if (event.keyCode == 13) {
  //     editarTarea(event.path[1].id, event.path[0].value);
  //   }
  // });

  const getContador = () => {
    return localStorage.getItem("contador");
  };

  const setContador = () => {
    localStorage.setItem("contador", contador);
  };

  const getArregloTareas = () => {
    return JSON.parse(localStorage.getItem("arregloTareas"));
  };

  const setArregloTareas = (event, status) => {
    setContador();
    localStorage.setItem("arregloTareas", JSON.stringify(arregloTareas));

    if(status == 1){

      listarTareas(event);
    }

    if(status == 2){
      listarTareasDelete(event);
    }
  };

  const inicializarContador = () => {
    if (getContador() != null) {
      contador = getContador();
    }
  };

  const agregarTarea = (event, status, description) => {
    contador++;
    let objetoTarea = {
      id: contador,
      descripcion: description,
    };
    if (getArregloTareas() != null) {
      arregloTareas = getArregloTareas();
    }

    arregloTareas.push(objetoTarea);
    setArregloTareas(event, status);
  };

  const eliminarTarea = (event,status, idTarea) => {
    let datos = getArregloTareas();
    let newArreglo = [];
    if (datos != null) {
      for (const tarea of datos) {
        if (tarea.id != idTarea) {
          newArreglo.push(tarea);
        }
      }
    }
    arregloTareas = newArreglo;
    setArregloTareas(event, status);
  };

 const listarTareasDelete = (event) => {

    console.log("hola estamos eliminando")
   console.log(event.path);
    console.log(event.path[2].children[1]);
    const litask = event.path[2];

    litask.innerHTML = "";
    let datos = getArregloTareas().reverse();
    for (const tarea of datos) {
      litask.innerHTML += `
                          <li id= "${tarea.id}">
                            <input
                              class="form-check-input"
                              type="checkbox"
                              value=""
                              id="flexCheckDefault"
                            />
                            <label
                              class="form-check-label"
                              for="flexCheckDefault"
                            >
                              ${tarea.id}
                            </label>
                            <input type="text" class="input-tarea" value ="${tarea.descripcion}"/>
                            <button
                              type="button"
                              class="boton-eliminar btn-dark"
                            >
                              X
                            </button>
                          </li>
    `;
    }
  };

  const listarTareas = (event) => {

    // console.log(event.path);
    // console.log(event.path[1].children[1]);
    const litask = event.path[1].children[1];

    litask.innerHTML = "";
    let datos = getArregloTareas().reverse();
    for (const tarea of datos) {
      litask.innerHTML += `
                          <li id= "${tarea.id}">
                            <input
                              class="form-check-input"
                              type="checkbox"
                              value=""
                              id="flexCheckDefault"
                            />
                            <label
                              class="form-check-label"
                              for="flexCheckDefault"
                            >
                              ${tarea.id}
                            </label>
                            <input type="text" class="input-tarea" value ="${tarea.descripcion}"/>
                            <button
                              type="button"
                              class="boton-eliminar btn-dark"
                            >
                              X
                            </button>
                          </li>
    `;
    }
  };

  const editarTarea = (idTarea, description) => {
    let newTarea = {
      id: idTarea,
      descripcion: description,
    };
    let datos = getArregloTareas();
    let newArreglo = [];
    if (datos != null) {
      for (const tarea of datos) {
        if (tarea.id == idTarea) {
          newArreglo.push(newTarea);
        } else {
          newArreglo.push(tarea);
        }
      }
    }
    arregloTareas = newArreglo;
    setArregloTareas();
  };

  //Método para limpior todas las tareas
  const limpiarTodo = () => {
    arregloTareas = [];
    contador = 0;
    setArregloTareas();
    setContador();
  };

  //inicio
  inicializarContador();
  //listarTareas();
};

export default AddTask;
