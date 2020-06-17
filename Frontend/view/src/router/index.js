import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/blogger/:id',
    name: 'Blogger',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Blogger.vue')
  },
  {
    path: '/journey/:id',
    name: 'Journey',
    component: () => import('../views/Journey.vue')
  },
  {
    path: '/post/:id',
    name: 'Post',
    component: () => import('../views/Post.vue')
  },
  {
    path: '/post/:id/addPicture',
    name: 'AddPicture',
    component: () => import('../views/AddPicture.vue')
  },
  {
    path: '/blogger/:id/addJourney',
    name: 'AddJourney',
    component: () => import('../views/AddJourney.vue')
  },
]

const router = new VueRouter({
  routes
})

export default router
