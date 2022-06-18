const url1 = "http://localhost:8080/tasks/";
const url2 = "http://localhost:8080/list/";
const ulLists = document.querySelector(".ul-listas");

const AddTask = async () => {
  //método para agregar una tarea
  ulLists.addEventListener("click", (event) => {
    if (event.path[0].type == "button") {
      if (event.path[0].classList.value == "boton-agregar") {
        addTasks(event, 1, "");
      }
    }
  });

  //método para eliminar una tarea
  ulLists.addEventListener("click", (event) => {
    if (event.path[0].type == "button") {
      if (event.path[0].classList.value == "boton-eliminar btn-dark") {
        deleteTaks(event, event.path[1].id);
      }
    }
  });

    //método editar
  ulLists.addEventListener("keypress", (event) => {
    if (event.keyCode == 13) {
      console.log(event.path[1].id)
      console.log(event.path[0].value)
      console.log(event.path[1].children[0].checked)
      // editarTarea(event.path[1].id, event.path[0].value);
    }
  });
  //método para edinar el estado de las tareas
  ulLists.addEventListener("click", (event) => {

    if(event.target.classList[0] == "form-check-input"){
      console.log(event.path[1].id)
      console.log(event.path[1].children[2].value)
      console.log(event.path[1].children[0].checked)
      // editarTarea(event.path[1].id, event.path[0].value);
    }
  });


  // botonLimpiar.addEventListener("click", () => {
  //   //método Limpiar
  //   limpiarTodo();
  // });


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
          idlist: { id: idList },
        }),
      })
        .then(() => {
          const rutaLi = event.path[1].children[1];
          listarTareas(rutaLi, idList);
        })
        .catch((err) => {
          console.log(err);
        });
    }
  };

  const deleteTaks = (event, idTask) => {
    Swal.fire({
      title: "¿deseas eliminar esta Tarea?",
      text: "¡No podra revertir esto!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "¡Si, Eliminar!",
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire("¡Eliminada!", "success");

        fetch(url1 + idTask, {
          method: "DELETE",
        }).then(() => {
          listarTareas(event.path[3].children[1], event.path[6].id);
        });
      }
    });
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
  const mostrar = (data, rutaLi) => {
    console.log(data);
    var resultados = "";
    const litask = rutaLi;
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

  const listarTareas = (rutaLi, idList) => {
    //Procedimiento Mostrar
    fetch(url2 + idList)
      .then((response) => response.json())
      .then((data) => {
        mostrar(data, rutaLi, idList);
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
  };

  //Método para limpiar todas las tareas
  const limpiarTodo = () => {};

  //inicio
  // listarTareas();
};

export default AddTask;
