
//学生
var store_student = new Ext.data.Store({
	model:'model_student',
	proxy: {
		type:'ajax',
		url:'queryStuAction.action',
		reader: {
            type: 'json',
            root: 'stuList'
        },
		autoLoad: false
	}
//	 data : [
//	         {name: 'Jamie', num: 'Avins'}
//	     ]
});

//所有班级
var store_grade = new Ext.data.Store({
    model:'model_grade',
    proxy: {
        type:'ajax',
        url:'queryGradeAction.action',
        reader: {
            type: 'json',
            root: 'listGrade'
        },
        autoLoad: false
    }
});

//所有有效的班级
var store_gradeEffect = new Ext.data.Store({
    model:'model_grade',
    proxy: {
        type:'ajax',
        url:'queryEffectGradeAction.action',
        reader: {
            type: 'json',
            root: 'listGrade'
        },
        autoLoad: false
    }
});

//查询所有的学期
var store_term = new Ext.data.Store({
    model:'model_term',
    proxy: {
        type:'ajax',
        url:'queryTermAction.action',
        reader: {
            type: 'json',
            root: 'listTerm'
        },
        autoLoad: false
    }
});

//查询有效的学期
var store_termEffect = new Ext.data.Store({
    model:'model_term',
    proxy: {
        type:'ajax',
        url:'selectTermAction.action',
        reader: {
            type: 'json',
            root: 'term'
        }
        // autoLoad: true
    }
});

//关系
var store_relation = new Ext.data.Store({
    fields: ['key', 'value'],
    data : [
            {"key":"0", "value":"爷爷"},
            {"key":"1", "value":"奶奶"},
             {"key":"2", "value":"爸爸"},
            {"key":"3", "value":"妈妈"},
        ],
    autoLoad: true
});


//学生查询类型
var store_querytype = new Ext.data.Store({
    fields: ['key', 'value'],
    data : [
            {"key":"new", "value":"该月新进学生"},
            {"key":"out", "value":"该月退学学生"},
            {"key":"in", "value":"该月在校学生"}
        ],
    autoLoad: true
});

//查询所有的教师
var store_teacher = new Ext.data.Store({
    model:'model_teacher',
    proxy: {
        type:'ajax',
        url:'queryTeacherAction.action',
        reader: {
            type: 'json',
            root: 'list'
        }
    }
});

//查询有效的教师
var store_teacherEffect = new Ext.data.Store({
    model:'model_teacher',
    proxy: {
        type:'ajax',
        url:'queryEffectTeacherAction.action',
        reader: {
            type: 'json',
            root: 'list'
        }
        // autoLoad: true
    }
});