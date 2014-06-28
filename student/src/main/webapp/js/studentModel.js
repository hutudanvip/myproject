//学生
Ext.define('model_student', {
     extend: 'Ext.data.Model',
     fields: [
         {name: 'id', type: 'string'},
         {name: 'createTime', type: 'date'},
         {name: 'lastUpdateTime',  type: 'date'},
         {name: 'number',  type: 'string'},

         {name: 'describe', type: 'string'},
         {name: 'iseffective', type: 'int'},
         {name: 'name',  type: 'string'},
         {name: 'address',  type: 'string'},

         {name: 'grade'},
             {name: 'gradeName', 
             type: 'string',
             convert: function(value, record) {
                 if(record != null){
                     var grade  = record.get('grade');
                     if(grade != null){
                         gradeName = grade.name;
                     }
                     else{
                         gradeName = '';
                     }
                 }
                return gradeName;
            }},
        {name: 'term'},
             {name: 'termName', 
             type: 'string',
             convert: function(value, record) {
                 if(record != null){
                     var term  = record.get('term');
                     if(term != null){
                         termName = term.name;
                     }
                     else{
                         termName = '';
                     }
                 }
                return termName;
            }},

        {name: 'cellphone', type: 'string'},
        {name: 'genearchName',  type: 'string'},
        {name: 'relation',  type: 'string'},

        {name: 'age', type: 'int'},
        {name: 'gender', type: 'string'},
        {name: 'intime',  type: 'date'}
     ]
 });

//班级
Ext.define('model_grade', {
     extend: 'Ext.data.Model',
     fields: [
         {name: 'id', type: 'string'},
         {name: 'number', type: 'string'},
         {name: 'name',  type: 'string'},
         {name: 'createTime', type: 'date'},
         {name: 'lastUpdateTime',  type: 'date'},
         {name: 'iseffective'},
         {name: 'describe',  type: 'string'}
     ]
 });

//学期
Ext.define('model_term', {
     extend: 'Ext.data.Model',
     fields: [
         {name: 'id', type: 'string'},
         {name: 'number', type: 'string'},
         {name: 'name',  type: 'string'},
         {name: 'createTime', type: 'date'},
         {name: 'lastUpdateTime',  type: 'date'},
         {name: 'beginTime', type:'date'},
         {name: 'describe',  type: 'string'},
         {name: 'iseffective'}
     ]
 });

//教师
Ext.define('model_teacher', {
     extend: 'Ext.data.Model',
     fields: [
         {name: 'id', type: 'string'},
         {name: 'number', type: 'string'},
         {name: 'name',  type: 'string'},
         {name: 'createTime', type: 'date'},
         {name: 'lastUpdateTime',  type: 'date'},
         {name: 'iseffective'},
         {name: 'describe',  type: 'string'},
         {name: 'intime',  type: 'string'},
         {name: 'cellphone', type: 'string'},
         {name: 'leaveTime', type: 'date'}
     ]
 });