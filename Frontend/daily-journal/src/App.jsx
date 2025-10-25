import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
//import NewsList from "./pages/NewsList";
import CategoryList from "./pages/CategoryList";
import UserList from "./pages/UserList";

function App() {
  return (
    <Router>
      <nav style={{ padding: "10px", borderBottom: "1px solid #ccc" }}>
        <Link to="/users">Пользователи</Link>
        <Link to="/categories">Категории</Link>
      </nav>

      <Routes>
        <Route path="/users" element={<UserList />} />
        <Route path="/categories" element={<CategoryList />} />
      </Routes>
    </Router>
  );
}

export default App;
