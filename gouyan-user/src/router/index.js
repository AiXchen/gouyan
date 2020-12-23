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
import ReputationList from "@/views/rankinglist/ReputationList";
import DomesticBoxOfficeList from "@/views/rankinglist/DomesticBoxOfficeList";
import AmericanBoxOfficeList from "@/views/rankinglist/AmericanBoxOfficeList";
import Top100List from "@/views/rankinglist/Top100List";
import MovieOngoing from "../views/movie/MovieOngoing";
import MovieUpcoming from "../views/movie/MovieUpcoming";
import MovieClassics from "../views/movie/MovieClassics";
import MovieInfo from "../views/movie/MovieInfo";
import ActorInfo from "../views/actor/ActorInfo";
import CinemaInfo from "../views/cinema/CinemaInfo";
import ChooseSeat from "../views/pay/ChooseSeat";

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
    redirect: { name: 'home'},
    children: [
      { path: '/home/', name: 'home', component: Home },
      {
        path: '/movie/',
        component: Movie,
        name: 'movie',
        redirect: {name: '正在热映'},
        children: [
          { path: 'movieOngoing', name:'正在热映', component: MovieOngoing },
          { path: 'movieUpcoming', name: '即将上映', component: MovieUpcoming },
          { path: 'movieClassics', name: '经典影片', component: MovieClassics }
          ]
      },
      {
        path: '/movieInfo/:movieId',
        name: '电影详细信息',
        component: MovieInfo
      },
      {
        path: '/actor/:actorId',
        name: '演员详细信息',
        component: ActorInfo
      },
      {
        path: '/cinema/',
        component: Cinema,
        name: 'cinema'
      },
      {
        path: '/cinemaInfo/:cinemaId',
        name: '影院详细信息',
        component: CinemaInfo
      },
      {
        path: '/rankingList/',
        component: RankingList,
        name: 'rankingList',
        redirect: '/rankingList/reputationList',
        children: [
          { path: 'reputationList', name: '口碑热映榜', component: ReputationList},
          { path: 'domesticBoxOfficeList', name: '国内票房榜', component: DomesticBoxOfficeList},
          { path: 'americanBoxOfficeList', name: '北美票房榜', component: AmericanBoxOfficeList},
          { path: 'top100List', name: 'Top100榜', component: Top100List}
        ]
      },
      {
        path: '/ChooseSeat/:sessionId',
        component: ChooseSeat,
        name: 'chooseSeat',
      }
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

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location){
  return originalPush.call(this, location).catch(err => err)
}
export default router
