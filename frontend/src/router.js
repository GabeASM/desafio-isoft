import { createRouter, createWebHashHistory } from 'vue-router';

import Home from './pages/Home';
import Detalle from './pages/Detalle';
import AutosGenerados from './pages/AutosGenerados'

const routes = [
    {
        name: 'home',
        path: '/',
        component: Home,
    },
    {
        name: 'detalle',
        path: '/detalle/:id',
        component: Detalle,
        meta:{cache : true},
        props: true,
    },
    {
        name: 'autos_generados',
        path: '/generarAutos/:numero',
        component: AutosGenerados,
        meta: { keepAlive: true },
    }
];

const router = createRouter({
  routes,
  history: createWebHashHistory(),
});

export default router;