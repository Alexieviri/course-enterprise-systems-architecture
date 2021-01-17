package org.myspring.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema = "public", name = "changes")
public class Change {
    @Id
    @Column(name="id")
    private String id;

    @Column(name="change_type")
    private String changeType;

    @Column(name="entity_id")
    private Integer entityId;

    @Column(name="table_name")
    private String tableName;

    @Column(name="field_name")
    private String fieldName;

    @Column(name="field_new_value")
    private String fieldNewValue;

    public Change(){}

    public Change(String id, String changeType, Integer entityId, String tableName, String fieldName, String fieldNewValue) {
        this.id = id;
        this.changeType = changeType;
        this.entityId = entityId;
        this.tableName = tableName;
        this.fieldName = fieldName;
        this.fieldNewValue = fieldNewValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "Change{" +
                "id=" + id +
                ", changeType='" + changeType + '\'' +
                ", entityId=" + entityId +
                ", tableName='" + tableName + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldNewValue='" + fieldNewValue + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Change change = (Change) o;
        return Objects.equals(id, change.id) &&
                Objects.equals(changeType, change.changeType) &&
                Objects.equals(entityId, change.entityId) &&
                Objects.equals(tableName, change.tableName) &&
                Objects.equals(fieldName, change.fieldName) &&
                Objects.equals(fieldNewValue, change.fieldNewValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, changeType, entityId, tableName, fieldName, fieldNewValue);
    }

    public String getFieldNewValue() {
        return fieldNewValue;
    }

    public void setFieldNewValue(String fieldNewValue) {
        this.fieldNewValue = fieldNewValue;
    }
}
