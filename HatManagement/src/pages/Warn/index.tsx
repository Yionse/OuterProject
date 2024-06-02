import { get } from "@/apis";
import { Table } from "antd";
import { useEffect, useState } from "react";

export default function Warn() {
  const [data, setData] = useState([]);
  const initData = async () => {
    const data = await get("/warningInfo/selectList");
    setData(data as any);
  };
  useEffect(() => {
    initData();
  }, []);

  const columns = [
    {
      dataIndex: "employeeId",
      title: "用户编号",
    },
    {
      dataIndex: "employeeName",
      title: "姓名",
      render: (value: any) => <span>{value ? value : "暂无报警人"}</span>,
    },
    {
      dataIndex: "createTime",
      title: "报警时间",
    },
    {
      dataIndex: "address",
      title: "报警地点",
    },
    {
      dataIndex: "warningType",
      title: "报警类型",
    },
  ];
  return <Table dataSource={data} columns={columns} />;
}
