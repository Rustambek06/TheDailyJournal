import { apiRequest } from "./api";

export const NewsService = {
    getAll: () => apiRequest("/news"),
    create: (data) => apiRequest("/news", "POST", data),
    delete: (id) => apiRequest(`/news/${id}`, "DELETE"),
};