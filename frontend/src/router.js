import { createRouter, createWebHashHistory } from 'vue-router';

import Home from './pages/Home';
import Detalle from './pages/Detalle';
import AutosGenerados from './pages/AutosGenerados'
import AutosFiltrados from './pages/AutosFiltrados'

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
        props: true,
    },
    {
        name: 'autos_generados',
        path: '/generarAutos/:numero',
        component: AutosGenerados,
    },
    {
        name: 'autos_filtrados',
        path: '/filtro',
        component: AutosFiltrados,
    }
];

const router = createRouter({
  routes,
  history: createWebHashHistory(),
});

export default router;