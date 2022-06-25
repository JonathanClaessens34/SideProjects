import {createWebHistory, createRouter} from 'vue-router'
import LandingPage from '@/pages/LandingPage.vue'
import DetailedPage from '@/pages/DetailedPage.vue'



const routes = [
    {
        path: '/',
        name: 'LandingPage',
        component: LandingPage
    },
    {
        path:'/detailed',
        name: 'DetailedPage',
        component: DetailedPage
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;


