import {createRouter, createWebHistory} from 'vue-router';
import Test from './atest';

const routes = [
    {
        path: '/',
        name: '',
        component: () => import('@/views/Index.vue'),
        meta: [{name: '', path: '/'}],
        redirect: '/test',
        children: [Test],
    },
];

const router = new createRouter({
    history: createWebHistory(),
    routes: routes,
});


export default router;
