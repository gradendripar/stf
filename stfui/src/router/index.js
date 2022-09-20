import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

export const routes = [
    {
        path: '/',
        name: 'Login',
        component: () => import('@/views/Login.vue')
    },
    {
        path: '/admin/post',
        name: 'Post',
        component: () => import('@/views/Post.vue')
    }
];

export default new VueRouter({
    mode: 'hash',
    base: process.env.BASE_URL,
    routes
});
