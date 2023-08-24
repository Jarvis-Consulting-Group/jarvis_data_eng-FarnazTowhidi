import './App.css';

// Import Styles
import 'bootstrap/dist/css/bootstrap.min.css';
import NavbarApp from './component/Navbar/NavbarApp';
import Router from './component/Router/Router';

function App() {
  return (
    <div className="App">
      <NavbarApp></NavbarApp>
      <Router></Router>
    </div>
  );
}

export default App;
