package com.dream.design.singleton;

/**
 * @author jiangll01
 * @Date: 2020/7/6 15:50
 * @Description:  枚举的例子：通过枚举的方式可以将常量进行整合，
 * 再添加数据得时候，直接向枚举中添加
 */
public enum  ResultEnum {
    //成功
    SUCESS(10,"sss"),
    SUCCESS(200, "success"),
    //学校300-399
    SCHOOLCODEEXP(301, "学校代码不能为空！"),
    SCHOOLNAME(302,"学校名称不能为空"),
    SCHOOLAREA(303,"学校招生地区不能不空"),
    NULL_SUBJECTTYPE(304,"科目类别不可为空"),
    NULL_SCHOOLYEAR(305,"招生年限不可为空"),
    SUBCOLNAME(306,"学科属性不能为空"),
    ZSSFCODE(307,"招生省份编码不能为空"),
    NULL_BATCH(308,"招生批次不能为空"),
    //选科400-499
    SELECTCOURSE(401,"所选科目不能为空"),
    // 专业600-699
    NULL_PARAM_MAJOR_LEVEL(601, "参数【专业层次】不可为空") ,
    NULL_PARAM_MAJOR_CODE(602,"参数【专业代码】不可为空"),
    NULL_DISCIPLINENAME(603,"参数【专业名称】不可为空"),
    //录取批次线700-799
    NULL_PARAM_PROVINCE(701, "参数【省份】不可为空"),
    NULL_PARAM_EXAMINEE_CATEGORY(702, "参数【考生类别】不可为空"),
    //职业信息800-899
    NULL_PARAM_JOB_INFO_CODE(801,"参数【职业代码】不可为空"),
    //公共异常
    RUNEXECEPTION(500, "运行时异常"),
    PAGEEXECPTION(901, "分页参数当前页面不能为空"),
    PAGESIZEEXECPTION(902, "分页参数行数不能为空"),
    PARAMXECEPTION(903, "参数非法"),
    BIZEXECEPTION(904, "业务异常"),
    UNDEFINE(-1, "未定义异常信息");
    private int code;
    private String msg;
    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
