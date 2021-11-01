import NavBar from "components/NavBar";
import Footer from "components/Footer";
import DataTable from "components/DataTable";


function App() {
  return (
    // Como no React não aceita mais de um elemento no retorno, temos que usar essa tag. (fragment)
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary"> Olá Zika! </h1>
        <DataTable />
      </div>
      <Footer />
    </>
  );
}

export default App;
