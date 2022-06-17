import listModel from "@templates/listModel.js";

const url = "http://localhost:8080/list/";
const ulLists = document.querySelector(".ul-listas");
const buttonAddList = document.querySelector(".boton-agregar-lista");
const input = document.querySelector("#input-new-list");

//Local Starage
var arregloLists = [];
var contador = 0;

const AddLists = async () => {
  //método para agregar una lista
  buttonAddList.addEventListener("click", () => {
    if (input.value != "") {
      let name = input.value;
      input.value = "";
      addList(name);
    } else {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Por favor ingrese un nombre para la lista de tareas",
      });
    }
  });

  //método para agregar una lista con la tecla enter
  input.addEventListener("keypress", (event) => {
    //método editar
    if (event.keyCode == 13) {
      if (input.value != "") {
        let name = input.value;
        input.value = "";
        addList(name);
      } else {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Por favor ingrese un nombre para la lista de tareas",
        });
      }
    }
  });
  //método para eliminar una tarea
  ulLists.addEventListener("click", (event) => {
    if (event.path[0].type == "button") {
      if (event.path[0].classList.value == "btn-delete-list btn-close") {
        deleteLists(event.path[4].id);
      }
    }
  });

  const getContador = () => {
    return localStorage.getItem("contador");
  };

  const setContador = () => {
    localStorage.setItem("contador", contador);
  };

  const getArregloLists = () => {
    return JSON.parse(localStorage.getItem("arregloLists"));
  };

  const setArregloLists = () => {
    // setContador();
    // localStorage.setItem("arregloLists", JSON.stringify(arregloLists));
    loadLists();
  };

  const inicializarContador = () => {
    if (getContador() != null) {
      contador = getContador();
    }
  };

  //función para agregar una lista
  const addList = async (name) => {
    await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: name,
        tasks: [],
      }),
    }).then((response) => {
      response.json();

      Swal.fire({
        position: "top-end",
        icon: "success",
        title: "La lista de atreas ha sido creada",
        showConfirmButton: false,
        timer: 1500,
      });
      loadLists();
    });
  };

  const deleteLists = async (idlist) => {
    Swal.fire({
      title: "¿deseas eliminar esta lista?",
      text: "¡No podra revertir esto!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "¡Si, Eliminar está lista!",
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire("¡Eliminada!", "success");

        console.log(idlist);
        fetch(url + idlist, {
          method: "DELETE",
        }).then((res) => {
          //res.json();
          loadLists();
        });
      }
    });
  };

  //funcion para mostrar los resultados
  const mostrar = (data) => {
    ulLists.innerHTML = "";
    let resultados = "";
    data.forEach((list) => {
      var textTasks = "";
      list.tasks.forEach((tarea) => {
        console.log(tarea);
        textTasks += `
                          <li id= "${tarea.idTask}">
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
                              ${tarea.idTask}
                            </label>
                            <input type="text" class="input-tarea" value ="${tarea.description}"/>
                            <button
                              type="button"
                              class="boton-eliminar btn-dark"
                            >
                              X
                            </button>
                          </li>
    `;
      });
      resultados += listModel(list, textTasks);
    });
    ulLists.innerHTML = resultados;
  };

  const loadLists = async () => {
    //Procedimiento Mostrar
    await fetch(url)
      .then((response) => response.json())
      .then((data) => mostrar(data))
      .catch((error) => console.log(error));
  };

  //inicio
  loadLists();
};

export default AddLists;
