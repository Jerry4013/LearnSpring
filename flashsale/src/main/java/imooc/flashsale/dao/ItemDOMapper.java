package imooc.flashsale.dao;

import imooc.flashsale.dataobject.ItemDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDOMapper {

    List<ItemDO> listItem();
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Mon May 13 08:36:27 EDT 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Mon May 13 08:36:27 EDT 2019
     */
    int insert(ItemDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Mon May 13 08:36:27 EDT 2019
     */
    int insertSelective(ItemDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Mon May 13 08:36:27 EDT 2019
     */
    ItemDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Mon May 13 08:36:27 EDT 2019
     */
    int updateByPrimaryKeySelective(ItemDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Mon May 13 08:36:27 EDT 2019
     */
    int updateByPrimaryKey(ItemDO record);

    int increaseSales(@Param("id")Integer id,@Param("amount")Integer amount);
}