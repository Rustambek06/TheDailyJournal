import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";
import NewsList from "./pages/NewsList.jsx";
import CategoryList from "./pages/CategoryList.jsx";

function App() {
    return (
        <Router>
            <nav style={{padding: "10px", borderBottom: "1px solid #ccc"}}>
                <Link to="/news" style={{marginRight: "10px"}}>Новости</Link>
                <Link to="/categories">Категории</Link>
            </nav>

            <Routes>
                <Route path="/news" element={<NewsList />} />
                <Route path="/categories" element={<CategoryList />} />
            </Routes>
        </Router>
    );
}

export default App;