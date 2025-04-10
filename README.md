# Composite-Entity-Annotation
Custom script/config to consolidate verbose and lengthy entity class annotations into a single custom annotation, enforcing code standards and cutting down repeat code. Custom annotation will be processed as part of the build script, requiring no further work on the part of developers creating entities. Example:
(Before):
@Entity
@Table(name = "CUSTOMER", schema = "S1")
@Where(clause = "DELETED IS NULL")
@Getter
@Setter
public class Customer {...}

(After):
@CustomEntity(tableName = "CUSTOMER", 
                enableWhere = true)
public class Customer {...}

(How?):
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface CustomEntity {
boolean enableEntity() default true;
boolean enableTable() default true;
boolean enableGetter() default true;
boolean enableSetter() default true;
boolean enableWhere() default false;
String tableName();
String schema() default "S1";
String whereClause() default "DELETED IS NULL";
...
}
I will expand this to include some of the most common class level entity annotations of Hibernate, Lombok, etc, and write a custom annotation processor that unpacks the properties of @CustomEntity and applies the real annotations to the classes pre-compile. 
This will be woven into the build script, so any number of developers from different teams may create/modify entities in this component without additional concern as long as they use @CustomAnnotation. In a large project with complex development cycles, this approach will enforce clean uniformity, reducing the chances of difficult to trace persistence errors throughout the application.
