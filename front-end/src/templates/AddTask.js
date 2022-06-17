const url1 = "http://localhost:8080/tasks/";
const url2 = "http://localhost:8080/list/";
const ulLists = document.querySelector(".ul-listas");


const AddTask = async () => {
  ulLists.addEventListener("click", (event) => {
    //método para agregar una tarea
    if (event.path[0].type == "button") {
      if (event.path[0].classList.value == "boton-agregar") {
        addTasks(event, 1, "");
      }
    }
  });

  // botonLimpiar.addEventListener("click", () => {
  //   //método Limpiar
  //   limpiarTodo();
  // });

  // ulLists.addEventListener("click", (event) => {
  //   //método para eliminar una tarea
  //   if (event.path[0].type == "button") {
  //     if (event.path[0].classList.value == "boton-eliminar btn-dark") {
  //       // eliminarTarea(event, 2, event.path[1].id);
  //     }
  //   }
  // });

  // listaTarea.addEventListener("keypress", (event) => {
  //   //método editar
  //   if (event.keyCode == 13) {
  //     editarTarea(event.path[1].id, event.path[0].value);
  //   }
  // });

   const loadTasks = (event, status) => {
      if (status == 2) {
      listarTareasDelete(event);
    }
  };

  const addTasks = async (event, status, description) => {
    if (status == 1) {
      let idList = event.path[4].id;

      await fetch(url1, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        description: description,
        realized: false,
        idlist:{ id: idList}
      }),
    }).then(() =>{
      listarTareas(event, idList);
    }).catch((err)=>{
      console.log(err);
    });
    }
  };

  const eliminarTarea = (event, status, idTarea) => {
    // let datos = getArregloTareas();
    // let newArreglo = [];
    // if (datos != null) {
    //   for (const tarea of datos) {
    //     if (tarea.id != idTarea) {
    //       newArreglo.push(tarea);
    //     }
    //   }
    // }
    // arregloTareas = newArreglo;
    // setArregloTareas(event, status);
  };

  const listarTareasDelete = (event) => {
    // console.log("hola estamos eliminando");
    // console.log(event.path);
    // console.log(event.path[2].children[1]);
    // const litask = event.path[2];
    //
    // litask.innerHTML = "";
    // let datos = getArregloTareas().reverse();
    // for (const tarea of datos) {
    //   litask.innerHTML += `
    //                       <li id= "${tarea.id}">
    //                         <input
    //                           class="form-check-input"
    //                           type="checkbox"
    //                           value=""
    //                           id="flexCheckDefault"
    //                         />
    //                         <label
    //                           class="form-check-label"
    //                           for="flexCheckDefault"
    //                         >
    //                           ${tarea.id}
    //                         </label>
    //                         <input type="text" class="input-tarea" value ="${tarea.descripcion}"/>
    //                         <button
    //                           type="button"
    //                           class="boton-eliminar btn-dark"
    //                         >
    //                           X
    //                         </button>
    //                       </li>
    // `;
    // }
  };

  //funcion para mostrar los resultados
  const mostrar = (data, event, idList) => {

    console.log(data);
    // console.log(event.path[1].children[1])
    var resultados = "";
    const litask = event.path[1].children[1];
    litask.innerHTML = "";

      data.tasks.forEach((task) => {
        resultados += `
                          <li id= "${task.idTask}">
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
                              ${task.idTask}
                            </label>
                            <input type="text" class="input-tarea" value ="${task.description}"/>
                            <button
                              type="button"
                              class="boton-eliminar btn-dark"
                            >
                              X
                            </button>
                          </li>
      `;
    });
    litask.innerHTML = resultados;
  };

  const listarTareas = (event, idList) => {
    //Procedimiento Mostrar
    fetch(url2+idList)
      .then((response) => response.json())
      .then((data) => {
         mostrar(data, event, idList);
      })
      .catch((error) => console.log(error));
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
    // arregloTareas = newArreglo;
    // setArregloTareas();
  };

  //Método para limpiar todas las tareas
  const limpiarTodo = () => {

  };

  //inicio
  // listarTareas();
};

export default AddTask;
