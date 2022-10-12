import { BrowserRouter as Router } from "react-router-dom"
import { ThemeProvider } from "styled-components"
import { RoutersPage } from "./routers"
import { lightTheme } from "./styles/themes/themes"

export function App() {
   return (
      <ThemeProvider theme={lightTheme}>
         <h1>Hello world</h1>

         <Router>
            <RoutersPage />
         </Router>
      </ThemeProvider>
   )
}
