(function(e){function t(t){for(var r,a,c=t[0],u=t[1],i=t[2],p=0,f=[];p<c.length;p++)a=c[p],Object.prototype.hasOwnProperty.call(o,a)&&o[a]&&f.push(o[a][0]),o[a]=0;for(r in u)Object.prototype.hasOwnProperty.call(u,r)&&(e[r]=u[r]);l&&l(t);while(f.length)f.shift()();return s.push.apply(s,i||[]),n()}function n(){for(var e,t=0;t<s.length;t++){for(var n=s[t],r=!0,c=1;c<n.length;c++){var u=n[c];0!==o[u]&&(r=!1)}r&&(s.splice(t--,1),e=a(a.s=n[0]))}return e}var r={},o={app:0},s=[];function a(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,a),n.l=!0,n.exports}a.m=e,a.c=r,a.d=function(e,t,n){a.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},a.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},a.t=function(e,t){if(1&t&&(e=a(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(a.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)a.d(n,r,function(t){return e[t]}.bind(null,r));return n},a.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return a.d(t,"a",t),t},a.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},a.p="/expenses/";var c=window["webpackJsonp"]=window["webpackJsonp"]||[],u=c.push.bind(c);c.push=t,c=c.slice();for(var i=0;i<c.length;i++)t(c[i]);var l=u;s.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("cd49")},"034f":function(e,t,n){"use strict";n("85ec")},"150b":function(e,t,n){},5539:function(e,t,n){},6774:function(e,t,n){},"7fee":function(e,t,n){},"85ec":function(e,t,n){},9873:function(e,t,n){"use strict";n("5539")},cd49:function(e,t,n){"use strict";n.r(t);var r=n("2b0e"),o=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("HelloWorld")],1)},s=[],a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"hello"},[n("h1",[e._v("My Expenses")]),n("div",{staticClass:"categories-with-expenses"},[e._l(e.categories,(function(e){return[n("category-with-expenses",{key:e.name,attrs:{category:e}})]})),n("form",{on:{submit:function(t){return t.preventDefault(),e.postNewCategory(t)}}},[n("input",{directives:[{name:"model",rawName:"v-model",value:e.newCategoryName,expression:"newCategoryName"}],attrs:{type:"text"},domProps:{value:e.newCategoryName},on:{input:function(t){t.target.composing||(e.newCategoryName=t.target.value)}}}),n("button",{attrs:{type:"submit"}},[e._v(" + ")])])],2)])},c=[],u=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"category-with-expenses"},[n("h2",[e._v(e._s(e.category.name))]),n("expenses",{attrs:{expenses:e.category.expenses}})],1)},i=[],l=function(){var e=this,t=e.$createElement,n=e._self._c||t;return e.expenses&&e.expenses.length>0?n("div",[n("table",[e._l(e.expenses,(function(t){return[n("tr",{key:t.name},[n("td",[e._v(e._s(t.name))]),n("td",[e._v(e._s(t.amount))])])]}))],2)]):e._e()},p=[],f=r["a"].extend({name:"HelloWorld",props:{expenses:Array},data:function(){return{}}}),d=f,h=(n("f1c2"),n("2877")),g=Object(h["a"])(d,l,p,!1,null,"258dd61c",null),m=g.exports,y=r["a"].extend({name:"HelloWorld",props:{category:Object},components:{Expenses:m},data:function(){return{}}}),v=y,b=(n("edbe"),Object(h["a"])(v,u,i,!1,null,"7f9206b8",null)),x=b.exports,_=r["a"].extend({name:"HelloWorld",props:{},components:{CategoryWithExpenses:x},data:function(){return{categories:[],newCategoryName:""}},mounted:function(){this.fetchCategories()},methods:{fetchCategories:function(){var e=this;console.log("http://localhost:8080/expenses/"),fetch("http://localhost:8080/expenses/categories/").then((function(e){return e.json()})).then((function(t){e.categories=t}))},postNewCategory:function(){var e=this;console.log("Hello world");var t={name:this.newCategoryName};fetch("http://localhost:8080/expenses/categories/",{method:"POST",body:JSON.stringify(t),headers:{"Content-Type":"application/json"}}).then((function(e){return e.json()})).then((function(t){t.status&&"OK"!==t.status&&alert(t.message),t.name&&e.fetchCategories()}))}}}),w=_,O=(n("9873"),Object(h["a"])(w,a,c,!1,null,"cb863c88",null)),j=O.exports,C=r["a"].extend({name:"App",components:{HelloWorld:j}}),N=C,P=(n("034f"),Object(h["a"])(N,o,s,!1,null,null,null)),E=P.exports;n("150b");r["a"].config.productionTip=!1,new r["a"]({render:function(e){return e(E)}}).$mount("#app")},edbe:function(e,t,n){"use strict";n("7fee")},f1c2:function(e,t,n){"use strict";n("6774")}});
//# sourceMappingURL=app.fc7ceb64.js.map