import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
//import NewsList from "./pages/NewsList";
import CategoryList from "./pages/CategoryList";
import UserList from "./pages/UserList";
import NewsList from "./pages/NewsList";

function App() {
  return (
    <Router>
      <nav style={{ padding: "10px", borderBottom: "1px solid #ccc" }}>
        <Link to="/news">Новости</Link>
        <Link to="/categories">Категории</Link>
        <Link to="/users">Пользователи</Link>
      </nav>

      <Routes>
        <Route path="/news" element={<NewsList />} />
        <Route path="/categories" element={<CategoryList />} />
        <Route path="/users" element={<UserList />} />
      </Routes>
    </Router>
  );
}

export default App;
