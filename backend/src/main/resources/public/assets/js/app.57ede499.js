(function(e){function t(t){for(var o,a,u=t[0],i=t[1],c=t[2],l=0,f=[];l<u.length;l++)a=u[l],Object.prototype.hasOwnProperty.call(r,a)&&r[a]&&f.push(r[a][0]),r[a]=0;for(o in i)Object.prototype.hasOwnProperty.call(i,o)&&(e[o]=i[o]);p&&p(t);while(f.length)f.shift()();return s.push.apply(s,c||[]),n()}function n(){for(var e,t=0;t<s.length;t++){for(var n=s[t],o=!0,u=1;u<n.length;u++){var i=n[u];0!==r[i]&&(o=!1)}o&&(s.splice(t--,1),e=a(a.s=n[0]))}return e}var o={},r={app:0},s=[];function a(t){if(o[t])return o[t].exports;var n=o[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,a),n.l=!0,n.exports}a.m=e,a.c=o,a.d=function(e,t,n){a.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},a.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},a.t=function(e,t){if(1&t&&(e=a(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(a.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var o in e)a.d(n,o,function(t){return e[t]}.bind(null,o));return n},a.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return a.d(t,"a",t),t},a.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},a.p="/expenses/";var u=window["webpackJsonp"]=window["webpackJsonp"]||[],i=u.push.bind(u);u.push=t,u=u.slice();for(var c=0;c<u.length;c++)t(u[c]);var p=i;s.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("cd49")},"034f":function(e,t,n){"use strict";n("85ec")},"150b":function(e,t,n){},"51a7":function(e,t,n){"use strict";n("5b5d")},"5b5d":function(e,t,n){},6774:function(e,t,n){},"85ec":function(e,t,n){},b238:function(e,t,n){},cd49:function(e,t,n){"use strict";n.r(t);var o=n("2b0e"),r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("HelloWorld")],1)},s=[],a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"hello"},[n("h1",[e._v("My Expenses")]),n("div",{staticClass:"categories-with-expenses"},[e._l(e.categories,(function(t){return[n("category-with-expenses",{key:t.name,attrs:{category:t},on:{newCategoryAdded:e.fetchCategories}})]})),n("form",{on:{submit:function(t){return t.preventDefault(),e.postNewCategory(t)}}},[n("input",{directives:[{name:"model",rawName:"v-model",value:e.newCategoryName,expression:"newCategoryName"}],attrs:{type:"text"},domProps:{value:e.newCategoryName},on:{input:function(t){t.target.composing||(e.newCategoryName=t.target.value)}}}),n("button",{attrs:{type:"submit"}},[e._v(" + ")])])],2)])},u=[],i=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"category-with-expenses"},[n("h2",[e._v(e._s(e.category.name))]),n("form",{on:{submit:function(t){return t.preventDefault(),e.postNewExpense(t)}}},[n("input",{directives:[{name:"model",rawName:"v-model",value:e.newExpenseName,expression:"newExpenseName"}],attrs:{type:"text"},domProps:{value:e.newExpenseName},on:{input:function(t){t.target.composing||(e.newExpenseName=t.target.value)}}}),n("input",{directives:[{name:"model",rawName:"v-model",value:e.newExpenseAmount,expression:"newExpenseAmount"}],attrs:{type:"text"},domProps:{value:e.newExpenseAmount},on:{input:function(t){t.target.composing||(e.newExpenseAmount=t.target.value)}}}),n("button",{attrs:{type:"submit"}},[e._v(" + ")])]),n("expenses",{attrs:{expenses:e.category.expenses}})],1)},c=[],p=function(){var e=this,t=e.$createElement,n=e._self._c||t;return e.expenses&&e.expenses.length>0?n("div",[n("table",[e._l(e.expenses,(function(t){return[n("tr",{key:t.name},[n("td",[e._v(e._s(t.name))]),n("td",[e._v(e._s(t.amount))])])]}))],2)]):e._e()},l=[],f=o["a"].extend({name:"HelloWorld",props:{expenses:Array},data:function(){return{}}}),d=f,m=(n("f1c2"),n("2877")),h=Object(m["a"])(d,p,l,!1,null,"258dd61c",null),g=h.exports,x=o["a"].extend({name:"HelloWorld",props:{category:Object},components:{Expenses:g},data:function(){return{newExpenseName:"",newExpenseAmount:null}},methods:{postNewExpense:function(){var e=this,t={name:this.newExpenseName,amount:this.newExpenseAmount};fetch("http://localhost:8080/expenses/categories/"+this.category.id+"/expenses/",{method:"POST",body:JSON.stringify(t),headers:{"Content-Type":"application/json"}}).then((function(e){return e.json()})).then((function(t){t.status&&"OK"!==t.status&&alert(t.message),t.name&&(e.$emit("newCategoryAdded"),e.clearInputs())}))},clearInputs:function(){this.newExpenseName="",this.newExpenseAmount=null}}}),v=x,y=(n("f54d"),Object(m["a"])(v,i,c,!1,null,"7189426c",null)),w=y.exports,b=o["a"].extend({name:"HelloWorld",props:{},components:{CategoryWithExpenses:w},data:function(){return{categories:[],newCategoryName:""}},mounted:function(){this.fetchCategories()},methods:{fetchCategories:function(){var e=this;console.log("http://localhost:8080/expenses/"),fetch("http://localhost:8080/expenses/categories/").then((function(e){return e.json()})).then((function(t){e.categories=t}))},postNewCategory:function(){var e=this;console.log("Hello world");var t={name:this.newCategoryName};fetch("http://localhost:8080/expenses/categories/",{method:"POST",body:JSON.stringify(t),headers:{"Content-Type":"application/json"}}).then((function(e){return e.json()})).then((function(t){t.status&&"OK"!==t.status&&alert(t.message),t.name&&e.fetchCategories()}))}}}),_=b,E=(n("51a7"),Object(m["a"])(_,a,u,!1,null,"7130ced3",null)),N=E.exports,O=o["a"].extend({name:"App",components:{HelloWorld:N}}),C=O,j=(n("034f"),Object(m["a"])(C,r,s,!1,null,null,null)),P=j.exports;n("150b");o["a"].config.productionTip=!1,new o["a"]({render:function(e){return e(P)}}).$mount("#app")},f1c2:function(e,t,n){"use strict";n("6774")},f54d:function(e,t,n){"use strict";n("b238")}});
//# sourceMappingURL=app.57ede499.js.map