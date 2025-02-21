import React, { useEffect, useState } from 'react';
import { DownOutlined } from '@ant-design/icons';
import { Tree } from 'antd';
import api from './api/api';
import AddResource from './AddResource';

const toTreeDataMapping = (data) => {
  return data.map((item) => {
    return {
      title: item.name,
      key: item.name,
      children: item.children ? toTreeDataMapping(item.children) : [],
    };
  });
}

const DecentralizedData = () => {
  const [treeData, setTreeData] = useState([]);

  const fetchTreeData = async () => {
    const data = await api.getTree('g2', 'htdll');
    setTreeData(toTreeDataMapping([data]));
  }

  useEffect(() => {
    fetchTreeData();
  }, [])

  const onSelect = (selectedKeys, info) => {
    console.log('selected', selectedKeys, info);
  };

  return (
    <div style={{ display: "flex", gap: "64px", padding: "64px" }}>
      <Tree
        style={{ width: "30vw" }}
        showLine
        switcherIcon={<DownOutlined />}
        onSelect={onSelect}
        treeData={treeData}
      />

      <AddResource fetchTreeData={fetchTreeData} />

    </div>
  );
};
export default DecentralizedData;