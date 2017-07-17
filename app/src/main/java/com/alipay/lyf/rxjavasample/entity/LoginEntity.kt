package com.alipay.lyf.rxjavasample.entity

/**
 * Created by 01F on 2017/6/10.
 */
data class LoginEntity(val jsessionid:String,val user:UserBean)

data class UserBean(val usersex:String,val unitallname:String,val unitname:String,
                    val collegeid:Int,val unitid:Int,val collegeallname:String,
                    val userid:Int,val username:String)