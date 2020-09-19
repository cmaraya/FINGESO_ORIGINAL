import http from "../http-common";

class LocalDataService {
  getAll() {
    return http.get("/locales");
  }

  get(id) {
    return http.get(`/locales/${id}`);
  }

  create(data) {
    return http.post("/locales", data);
  }

  update(id, data) {
    return http.put(`/locales/${id}`, data);
  }

  delete(id) {
    return http.delete(`/locales/${id}`);
  }

  deleteAll() {
    return http.delete(`/locales`);
  }

  findByNombre(nombre) {
    return http.get(`/locales?nombre=${nombre}`);
  }
}

export default new LocalDataService();
