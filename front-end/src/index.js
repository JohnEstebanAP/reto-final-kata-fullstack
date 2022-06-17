import StartTemplate from "@templates/Template.js";

//Funcion auto ejecotable
(async function App() {
  try {
    const start = await StartTemplate();
    start();
  } catch (error) {
    console.error(error);
  }
})();
