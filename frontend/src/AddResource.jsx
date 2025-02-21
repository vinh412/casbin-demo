import { Button, Form, Input, message, Typography } from 'antd'
import React from 'react'
import api from './api/api'

function AddResource({ fetchTreeData }) {
    const [messageApi, contexHolder] = message.useMessage();
    const onFinish = async (values) => {
        await api.addResource(values);
        messageApi.success('Resource added successfully');
        fetchTreeData();
    }
    return (
        <>
            {contexHolder}
            <div>
                <Typography.Title level={2} style={{ margin: 0 }}>Add Resource</Typography.Title>
                <Form onFinish={onFinish} layout='inline'>
                    <Form.Item label="Resource Name" name="name">
                        <Input />
                    </Form.Item>
                    <Form.Item label="Parent Name" name="parent">
                        <Input />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType='submit'>Add</Button>
                    </Form.Item>
                </Form>
            </div>
        </>
    )
}

export default AddResource