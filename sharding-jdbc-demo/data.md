
分库测试,使用简单的id发号器。下面批量插入八个用户，验证分库是否成功
```json
[
        {
            "name":"Jack",
            "age":11,
            "address":"Street One"
        },
        {
            "name":"Bob",
            "age":12,
            "address":"Street Two"
        },
        {
            "name":"Jessy",
            "age":13,
            "address":"Street Three"
        },
        {
            "name":"Jim",
            "age":14,
            "address":"Street Four"
        },
        {
            "name":"Lucy",
            "age":15,
            "address":"Street Five"
        },
        {
            "name":"Lily",
            "age":16,
            "address":"Street Six"
        },
        {
            "name":"Ben",
            "age":17,
            "address":"Street Seven"
        },
        {
            "name":"John",
            "age":18,
            "address":"Street Eight"
        }
    ]
```
分表测试： 
```json
{
    "order":{
        "userId":1,
        "description":"No1 order 2018-08-08"
    },
    "orderItems":[
        {
            "orderItemId":1,
            "userId":1,
            "description":"big tv"
        },{
            "orderItemId":2,
            "userId":1,
            "description":"beautiful air_conditioner"
        },{
            "orderItemId":5,
            "userId":1,
            "description":"suitable desk"
        }    
    ]
}

```

```json

{
    "order":{
        "userId":4,
        "description":"No2 order 2018-08-08"
    },
    "orderItems":[
        {
            "orderItemId":4,
            "userId":4,
            "description":"comfortable sofa"
        },{
            "orderItemId":6,
            "userId":4,
            "description":"good wine"
        },{
            "orderItemId":7,
            "userId":4,
            "description":"plate"
        },{
            "orderItemId":8,
            "userId":4,
            "description":"useful book"
        }    
    ]
}
```