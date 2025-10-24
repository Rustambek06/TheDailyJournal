import { apiRequest } from "./api";

export const CategoryService = {
    getAll: () => apiRequest("/categories"),
    create: (data) => apiRequest("/categories", "POST", data),
    delete: (id) => apiRequest(`/categories/${id}`, "DELETE"),
};