import {createStore} from 'vuex'

let url = 'http://localhost:8083/';
const headers = {Accept: "application/json"};

export default createStore({
    state: {
        stageopdrachten: [],
        stageopdrachtId: null,
        stageopdrachtDetailsPage: null,
        studenten: [],
        companyNameAsc: true,
        isLoading: false,
        titleAsc: true,
        dataReady: false,
        Pdf: null,
    },
    mutations: {
        _emptyStageopdrachten(state) {
            state.stageopdrachten = [];
        },
        _emptyStudenten(state) {
            state.studenten = [];
        },
        _emptyStageopdrachtDetailsPage(state) {
            state.stageopdrachtDetailsPage = null;
        },
        _updateStageopdrachtId(state, payload) {
            state.stageopdrachtId = payload;
            console.log("this id is " + this.stageopdrachtId);
        },
        _updateDataReady(state, payload) {
            state.dataReady = payload;
        },
        _updateCompanyNameAsc(state, payload) {
            state.companyNameAsc = payload;
        },
        _updateTitleAsc(state, payload) {
            state.titleAsc = payload;
        },
        _addStageopdrachten(state, payload) {
            state.stageopdrachten = payload.stageopdrachten;
        },
        _addStageopdracht(state, payload) {
            state.stageopdrachtDetailsPage = payload;
        },
        _addStudenten(state, payload) {
            state.studenten = payload;
        },
        _emptyPdf(state) {
            state.Pdf = null;
        },
        _addPdf(state, payload) {
            state.Pdf = payload;
        },
    },
    actions: {
        async fetchStageopdrachten({commit}) {
            commit('_emptyStageopdrachten');
            return fetch(url+ 'overview/', {headers})
            .then((response) => {
                if(response.status == 200){
                    return response.json();
                }else{
                    throw new Error(`error with status: ${response.status}`);
                }
            })
            .then((stageopdrachten) => {
                commit('_addStageopdrachten', {stageopdrachten: stageopdrachten});
                return stageopdrachten;
            })
            .catch((error) => {
                console.log(error);
            })
        },
        async fetchDetailedStageopdracht({commit}, id) {
            commit('_emptyStageopdrachtDetailsPage');
            return fetch(url+ `details/${id}`, {headers})
            .then((response) => {
                if(response.status == 200){
                    return response.json();
                }else{
                    throw new Error(`error with status: ${response.status}`);
                }
            })
            .then((stageopdracht) => {
                commit('_addStageopdracht', stageopdracht);
            })
            .catch((error) => {
                console.log(error);
            })
        },
        async fetchPDF({commit}, id) {
            commit('_emptyPdf');
            return fetch(url + `pdf/generate/${id}`, {headers})
                .then((response) => {
                    if (response.status == 200) {
                        console.log("test2")
                        return response.url;
                    } else {

                        throw new Error(`error with status: ${response.status}`);
                    }
                })
                .then((pdf) => {
                    commit('_addPdf', pdf);
                    console.log("wat is dit " + pdf);
                })
                .catch((error) => {
                    console.log(error);
                })
        },
        fetchStudenten: function (state) {
            state.commit('_emptyStudenten');
            fetch(url + 'details/student', {headers})
                .then((response) => {
                    if (response.status == 200) {
                        return response.json();
                    } else {
                        throw new Error(`error with status: ${response.status}`);
                    }
                })
                .then((studenten) => {
                    state.commit('_addStudenten', studenten.studentList);
                })
                .catch((error) => {
                    console.log(error);
                })
        },
        syncPost: function() {
            console.log("post wordt uitgevoerd");
            fetch(url + 'overview/synchronise', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(),
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Success:', data);

                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        },
        putDetailedPage: function(state, payload){
            fetch(url + 'details/' + payload.id, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(payload),
            })
            .then(response => response.json())
            .then(data => console.log(data)
            .then(error => console.log(error))
            )
        },
        putCompanyDetailed: function(state, payload){
            console.log(payload);
            fetch(url + 'details/editCompany/' + this.state.stageopdrachtDetailsPage.id, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(payload),
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Success:', data);

                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        },

        putContactPersonDetailed: function(state, payload){
            fetch(url + 'details/editContactPerson/' + this.state.stageopdrachtDetailsPage.id, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(payload),
            })
            .then(response => response.json())
                .then(data => {
                    console.log('Success:', data);

                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        },
        putSupervisorDetailed: function(state, payload){
            fetch(url + 'details/editSupervisor/' + this.state.stageopdrachtDetailsPage.id, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(payload),
            })
            .then(response => response.json())
                .then(data => {
                    console.log('Success:', data);

                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        },
        putStatusMainPage: function (state, payload) {
            return fetch(url + `details/${payload.id}/${payload.currentStatus}`,  {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(payload),
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Success:', data);
                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        },
        putStatusDetailedPage: function (state, payload) {
            return fetch(url + `details/${payload.id}/${payload.status}`,  {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(payload),
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Success:', data);
                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        },
    },
    modules: {},
    getters: {
        getStageopdrachten: state => state.stageopdrachten,
        getStageopdrachtDetailsPage: state => state.stageopdrachtDetailsPage
    }
})
