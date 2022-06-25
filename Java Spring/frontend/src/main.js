import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import gAuthPlugin from 'vue3-google-oauth2';

const app = createApp(App)

let gAuthClientId = '447751966406-1pdnvja1hfbttqm9h3fn4a9oatcej80l.apps.googleusercontent.com';
app.use(router).use(store).use(gAuthPlugin, {
    clientId: gAuthClientId,
    scope: 'email',
    prompt: 'consent',
}).mount('#app')


