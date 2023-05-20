import { createRouter, createWebHashHistory } from 'vue-router';

import Home from './pages/Home';
import Detalle from './pages/Detalle';

const routes = [
    {
        name: 'home',
        path: '/',
        component: Home,
    },
    {
        name: 'detalle',
        path: '/detalle',
        component: Detalle,
    }
];

const router = createRouter({
  routes,
  history: createWebHashHistory(),
});

export default router;