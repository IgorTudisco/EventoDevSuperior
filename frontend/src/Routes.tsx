// Para fazer o import precisamos add os tipos (yarn add @types/react-router-dom -D)
import Home from "pages/Home";
import Dashboard from "pages/Dashboard";
import { BrowserRouter, Switch, Route } from "react-router-dom"

function Routes() {
  return (

    // Usando uma teg especial do React over dom ($ yarn add react-router-dom@5.2.0).
    // Switch é um tipo do router dom.
    // Passamos o path usando a teg Route
    // Usamos o exact para informar que essa tag é exata.
    <BrowserRouter>
      <Switch>
        <Route path="/" exact>
          <Home />
        </Route>

        <Route path="/dashboard" exact>
          <Dashboard />
        </Route>
      </Switch>
    </BrowserRouter>

  );
}

export default Routes;