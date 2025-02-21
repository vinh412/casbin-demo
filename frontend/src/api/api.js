import axiosClient from "./axiosClient";

const api = {
    getTree: (ptype, name) => {
        const url = `/tree?ptype=${ptype}&name=${name}`;
        return axiosClient.get(url);
    },
    addResource: (resource) => {
        const url = '/resource';
        return axiosClient.post(url, resource);
    }
}

export default api;