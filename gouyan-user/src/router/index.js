import Vue from 'vue'
import VueRouter from 'vue-router'
import { Message }from 'element-ui'
import Login from "../views/Login";
import Welcome from "../views/Welcome";
import Register from "../views/Register";
import Error404 from "../views/Error404";
import Home from "../views/home/Home";
import Movie from "../views/movie/Movie";
import Cinema from "../views/cinema/Cinema";
import RankingList from "../views/rankinglist/Rankinglist";
import UserInfo from "../views/user/UserInfo";
import BillInfo from "../views/user/BillInfo";

Vue.use(VueRouter)

const routes = [
  {
    path:'/', redirect: 'login'
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/welcome',
    component: Welcome,
    redirect: '/home',
    children: [
      { path: '/home', component: Home },
      { path: '/movie', component: Movie },
      { path: '/cinema', component: Cinema },
      { path: '/rankingList', component: RankingList },
      { path: '/user', component: UserInfo},
      { path: '/bill', component: BillInfo}
    ]
  },
  {
    path: '/register',
    component: Register
  },{
    path: '/*',
    component: Error404
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})


//挂载路由导航守卫
router.beforeEach((to, from, next) =>{
  //to 将要访问的路径
  //from 从哪个页面来
  //next 一个放行函数

  if(to.path == '/login' || to.path == '/404' || to.path == '/register') return next();

  //获取token
  const token = window.sessionStorage.getItem("token")
  if(!token){
    Message.error('抱歉，请先登录')
    return next('/login');
  }
  next();
})

export default router
