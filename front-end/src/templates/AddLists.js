import listModel from "@templates/listModel.js";

const ulLists = document.querySelector(".ul-listas");
const buttonAddList = document.querySelector(".boton-agregar-lista");
const input = document.querySelector("#input-new-list");

//Local Starage
var arregloLists = [];
var contador = 0;

const AddLists = async () => {
  buttonAddList.addEventListener("click", () => {
    //método para agregar una lista

    console.log(input.value);
    if (input.value != "") {
      contador++;
      addList(contador, input.value);
    }
  });

  ulLists.addEventListener("click", (event) => {
    //método para eliminar una tarea
    if (event.path[0].type == "button") {
      if (event.path[0].classList.value == "btn-delete-list btn-close") {
        console.log(event.path);
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
    setContador();
    localStorage.setItem("arregloLists", JSON.stringify(arregloLists));
    loadLists();
  };

  const inicializarContador = () => {
    if (getContador() != null) {
      contador = getContador();
    }
  };

  const addList = (id, name) => {
    let objetoList = {
      id: id,
      name: name,
      tasks: [],
    };

    if (getArregloLists() != null) {
      arregloLists = getArregloLists();
    }

    arregloLists.push(objetoList);
    setArregloLists();
  };

  const deleteLists = (idlist) => {
    let datos = getArregloLists();
    let newArreglo = [];
    if (datos != null) {
      for (const list of datos) {
        if (list.id != idlist) {
          newArreglo.push(list);
        }
      }
    }
    arregloLists = newArreglo;
    setArregloLists();
  };

  const loadLists = () => {
    ulLists.innerHTML = "";
    let datos = getArregloLists();
    for (const list of datos) {
      ulLists.innerHTML += listModel(list);
    }
  };

  //inicio
  inicializarContador();
  loadLists();
};

export default AddLists;
