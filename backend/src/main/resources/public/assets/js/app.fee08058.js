(function(e){function t(t){for(var n,s,c=t[0],l=t[1],i=t[2],u=0,p=[];u<c.length;u++)s=c[u],Object.prototype.hasOwnProperty.call(r,s)&&r[s]&&p.push(r[s][0]),r[s]=0;for(n in l)Object.prototype.hasOwnProperty.call(l,n)&&(e[n]=l[n]);d&&d(t);while(p.length)p.shift()();return a.push.apply(a,i||[]),o()}function o(){for(var e,t=0;t<a.length;t++){for(var o=a[t],n=!0,c=1;c<o.length;c++){var l=o[c];0!==r[l]&&(n=!1)}n&&(a.splice(t--,1),e=s(s.s=o[0]))}return e}var n={},r={app:0},a=[];function s(t){if(n[t])return n[t].exports;var o=n[t]={i:t,l:!1,exports:{}};return e[t].call(o.exports,o,o.exports,s),o.l=!0,o.exports}s.m=e,s.c=n,s.d=function(e,t,o){s.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:o})},s.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},s.t=function(e,t){if(1&t&&(e=s(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var o=Object.create(null);if(s.r(o),Object.defineProperty(o,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)s.d(o,n,function(t){return e[t]}.bind(null,n));return o},s.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return s.d(t,"a",t),t},s.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},s.p="/expenses/";var c=window["webpackJsonp"]=window["webpackJsonp"]||[],l=c.push.bind(c);c.push=t,c=c.slice();for(var i=0;i<c.length;i++)t(c[i]);var d=l;a.push([0,"chunk-vendors"]),o()})({0:function(e,t,o){e.exports=o("cd49")},"034f":function(e,t,o){"use strict";o("85ec")},"0670":function(e,t,o){},"150b":function(e,t,o){},"321a":function(e,t,o){},"394d":function(e,t,o){},"633c":function(e,t,o){"use strict";o("394d")},"635b":function(e,t,o){"use strict";o("0670")},6558:function(e,t,o){"use strict";o("edb6")},"6be7":function(e,t,o){},"85ec":function(e,t,o){},"8d28":function(e,t,o){},"9ea2":function(e,t,o){"use strict";o("321a")},b9a4:function(e,t,o){"use strict";o("8d28")},cd49:function(e,t,o){"use strict";o.r(t);var n=o("2b0e"),r=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{attrs:{id:"app"}},[o("Main")],1)},a=[],s=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"hello"},[o("h1",[e._v("My Expenses for "+e._s(e.monthName)+" "+e._s(e.year))]),o("div",{staticClass:"categories-with-expenses"},[e._l(e.categories,(function(t){return[o("category-with-expenses",{key:t.name,attrs:{category:t},on:{newCategoryAdded:e.fetchCategories}})]})),o("button",{staticClass:"add-category-button shadow-effect",on:{click:function(t){return e.$refs.addCategoryModal.openModal()}}},[e._v("+")]),o("add-category-dialog",{ref:"addCategoryModal",on:{newCategoryAdded:e.fetchCategories}})],2)])},c=[],l=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"category-with-expenses shadow-effect",style:e.cssVars},[o("div",{staticClass:"card-title"},[o("h2",[e._v(e._s(e.category.name))])]),o("add-expense-dialog",{ref:"addExpenseModal",attrs:{category:e.category},on:{newExpenseAdded:e.fetchCategories}}),o("expenses",{attrs:{expenses:e.category.expenses}}),o("button",{staticClass:"add-expense-button",on:{click:function(t){return e.$refs.addExpenseModal.openModal()}}},[e._v(" + ")])],1)},i=[],d=function(){var e=this,t=e.$createElement,o=e._self._c||t;return e.expenses&&e.expenses.length>0?o("div",[o("table",[e._m(0),e._l(e.expenses,(function(t){return[o("tr",{key:t.name,staticClass:"table-row"},[o("td",[e._v(e._s(t.name))]),o("td",[e._v(e._s(e.getFormattedDate(t.modified)))]),o("td",[e._v(e._s(t.amount))])])]}))],2)]):e._e()},u=[function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("tr",[o("th",{staticClass:"expenses-title"},[e._v("Title")]),o("th",{staticClass:"expenses-date"},[e._v("Date")]),o("th",{staticClass:"expenses-amount"},[e._v("Amount")])])}],p=n["a"].extend({name:"HelloWorld",props:{expenses:Array},data(){return{}},methods:{getFormattedDate(e){const t=new Date(e),o={day:"numeric",month:"numeric"};return t.toLocaleDateString("en-US",o)}}}),f=p,m=(o("9ea2"),o("2877")),h=Object(m["a"])(f,d,u,!1,null,"8607d274",null),g=h.exports,y=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("modal",{ref:"modal",scopedSlots:e._u([{key:"header",fn:function(){return[o("h1",[e._v("Add a new Expense")])]},proxy:!0},{key:"body",fn:function(){return[o("form",{on:{submit:function(t){return t.preventDefault(),e.postNewExpense(t)}}},[o("input",{directives:[{name:"model",rawName:"v-model",value:e.newExpenseName,expression:"newExpenseName"}],attrs:{type:"text"},domProps:{value:e.newExpenseName},on:{input:function(t){t.target.composing||(e.newExpenseName=t.target.value)}}}),o("input",{directives:[{name:"model",rawName:"v-model",value:e.newExpenseAmount,expression:"newExpenseAmount"}],attrs:{type:"text"},domProps:{value:e.newExpenseAmount},on:{input:function(t){t.target.composing||(e.newExpenseAmount=t.target.value)}}}),o("button",{attrs:{type:"submit"}},[e._v(" + ")])])]},proxy:!0}])})},x=[],v=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("transition",{attrs:{name:"fade"}},[e.show?o("div",{staticClass:"modal"},[o("div",{staticClass:"modal__backdrop",on:{click:function(t){return e.closeModal()}}}),o("div",{staticClass:"shadow-effect modal__dialog",style:e.cssVars},[o("div",{staticClass:"modal__header"},[e._t("header"),o("button",{staticClass:"modal__close",attrs:{type:"button"},on:{click:function(t){return e.closeModal()}}},[o("svg",{attrs:{xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 352 512"}},[o("path",{attrs:{fill:"currentColor",d:"M242.72 256l100.07-100.07c12.28-12.28 12.28-32.19 0-44.48l-22.24-22.24c-12.28-12.28-32.19-12.28-44.48 0L176 189.28 75.93 89.21c-12.28-12.28-32.19-12.28-44.48 0L9.21 111.45c-12.28 12.28-12.28 32.19 0 44.48L109.28 256 9.21 356.07c-12.28 12.28-12.28 32.19 0 44.48l22.24 22.24c12.28 12.28 32.2 12.28 44.48 0L176 322.72l100.07 100.07c12.28 12.28 32.2 12.28 44.48 0l22.24-22.24c12.28-12.28 12.28-32.19 0-44.48L242.72 256z"}})])])],2),o("div",{staticClass:"modal__body"},[e._t("body")],2)])]):e._e()])},C=[],b={name:"Modal",props:{backgroundColor:{type:String,default:"#ffffff"}},data(){return{show:!1}},methods:{closeModal(){this.show=!1},openModal(){this.show=!0}},computed:{textColor(){return"#ffffff"===this.backgroundColor?"#000000":"#ffffff"},cssVars(){return{"--background-color":this.backgroundColor,"--text-color":this.textColor}}}},w=b,_=(o("6558"),Object(m["a"])(w,v,C,!1,null,"3d477f01",null)),O=_.exports,k=n["a"].extend({name:"addExpenseDialog",components:{Modal:O},props:{category:Object},data(){return{newExpenseName:"",newExpenseAmount:null}},methods:{openModal(){const e=this.$refs.modal;e.openModal()},postNewExpense(){const e={name:this.newExpenseName,amount:this.newExpenseAmount};fetch("http://localhost:8080/expenses/categories/"+this.category.id+"/expenses/",{method:"POST",body:JSON.stringify(e),headers:{"Content-Type":"application/json"}}).then(e=>e.json()).then(e=>{if(e.status&&"OK"!==e.status&&alert(e.message),e.name){this.$emit("newExpenseAdded");const e=this.$refs.modal;e.closeModal()}})}}}),E=k,M=Object(m["a"])(E,y,x,!1,null,null,null),N=M.exports,j=n["a"].extend({name:"HelloWorld",props:{category:Object},components:{Expenses:g,AddExpenseDialog:N},data(){return{newExpenseName:"",newExpenseAmount:null}},methods:{fetchCategories(){this.$emit("newCategoryAdded")},clearInputs(){this.newExpenseName="",this.newExpenseAmount=null},adjust(e,t){return"#"+e.replace(/^#/,"").replace(/../g,e=>("0"+Math.min(255,Math.max(0,parseInt(e,16)+t)).toString(16)).substr(-2))}},computed:{cssVars(){return{"--background-color":this.category.colorCode,"--darker-background-color":this.adjust(this.category.colorCode,-20),"--lighter-background-color":this.adjust(this.category.colorCode,20)}}}}),A=j,$=(o("d7f6"),Object(m["a"])(A,l,i,!1,null,"08b8e879",null)),P=$.exports,D=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("modal",{ref:"modal",attrs:{backgroundColor:e.pickedColor.colorCode},scopedSlots:e._u([{key:"header",fn:function(){return[o("h1",[e._v("Add a new Category")])]},proxy:!0},{key:"body",fn:function(){return[o("form",{on:{submit:function(t){return t.preventDefault(),e.postNewCategory(t)}}},[o("input",{directives:[{name:"model",rawName:"v-model",value:e.newCategoryName,expression:"newCategoryName"}],attrs:{type:"text"},domProps:{value:e.newCategoryName},on:{input:function(t){t.target.composing||(e.newCategoryName=t.target.value)}}}),o("color-picker",{attrs:{colorOptions:e.colorOptions},on:{change:e.newColorPicked}}),o("button",{attrs:{type:"submit"}},[e._v(" + ")])],1)]},proxy:!0}])})},S=[],V=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",e._l(e.colorOptions,(function(t){return o("div",{key:t.id,staticClass:"color-options"},[o("color-option",{attrs:{colorOption:t,pickedColor:e.pickedColor,radioGroupName:"colors"},on:{change:e.changeValue}})],1)})),0)},B=[],T=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"color-option",style:e.cssVars},[o("input",{directives:[{name:"model",rawName:"v-model",value:e.radioButtonValue,expression:"radioButtonValue"}],attrs:{type:"radio",id:e.colorOption.id,name:e.radioGroupName},domProps:{value:e.colorOption,checked:e._q(e.radioButtonValue,e.colorOption)},on:{change:function(t){e.radioButtonValue=e.colorOption}}}),o("label",{attrs:{for:e.colorOption.id}})])},L=[],F=n["a"].extend({name:"colorPicker",props:{colorOption:Object,pickedColor:Object,radioGroupName:String},computed:{radioButtonValue:{get:function(){return this.pickedColor},set:function(){this.$emit("change",this.colorOption)}},cssVars(){return{"--background-color":this.colorOption.colorCode}}}}),G=F,J=(o("633c"),Object(m["a"])(G,T,L,!1,null,"4ddd17dc",null)),I=J.exports,K=n["a"].extend({components:{ColorOption:I},name:"colorPicker",props:{colorOptions:Array},data(){return{pickedColor:{}}},methods:{changeValue:function(e){this.pickedColor=e,this.$emit("change",e)}}}),W=K,Y=(o("635b"),Object(m["a"])(W,V,B,!1,null,"28e68371",null)),H=Y.exports,U=n["a"].extend({name:"addCategoryDialog",components:{Modal:O,ColorPicker:H},data(){return{newCategoryName:"",colorOptions:[{colorCode:"#DAABD9",id:"PINK"},{colorCode:"#A4D2A3",id:"GREEN"},{colorCode:"#A7E1F0",id:"BLUE"}],pickedColor:{}}},methods:{openModal(){const e=this.$refs.modal;this.pickedColor={},e.openModal()},postNewCategory(){console.log(this.pickedColor);const e={name:this.newCategoryName,colorCode:this.pickedColor.colorCode};fetch("http://localhost:8080/expenses/categories/",{method:"POST",body:JSON.stringify(e),headers:{"Content-Type":"application/json"}}).then(e=>e.json()).then(e=>{if(e.status&&"OK"!==e.status&&alert(e.message),e.name){this.$emit("newCategoryAdded");const e=this.$refs.modal;e.closeModal()}})},newColorPicked(e){this.pickedColor=e}}}),q=U,z=Object(m["a"])(q,D,S,!1,null,null,null),R=z.exports,Q=n["a"].extend({name:"Main",props:{},components:{CategoryWithExpenses:P,AddCategoryDialog:R},data(){return{categories:[],month:null,year:null}},mounted(){this.setDefaultMonthAndYear(),this.fetchCategories()},methods:{fetchCategories(){console.log("http://localhost:8080/expenses/"),fetch("http://localhost:8080/expenses/categories?year="+this.year+"&month="+(this.month+1)).then(e=>e.json()).then(e=>{this.categories=e})},setDefaultMonthAndYear(){const e=new Date;this.month=e.getMonth(),this.year=e.getFullYear()}},computed:{monthName(){return"March"}}}),X=Q,Z=(o("b9a4"),Object(m["a"])(X,s,c,!1,null,"053435c2",null)),ee=Z.exports,te=n["a"].extend({name:"App",components:{Main:ee}}),oe=te,ne=(o("034f"),Object(m["a"])(oe,r,a,!1,null,null,null)),re=ne.exports;o("150b");n["a"].config.productionTip=!1,new n["a"]({render:function(e){return e(re)}}).$mount("#app")},d7f6:function(e,t,o){"use strict";o("6be7")},edb6:function(e,t,o){}});
//# sourceMappingURL=app.fee08058.js.map