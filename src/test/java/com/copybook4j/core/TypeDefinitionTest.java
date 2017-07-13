package com.copybook4j.core;

import org.junit.Test;

import java.util.List;

import static com.copybook4j.core.DataType.X;
import static com.copybook4j.core.DataType._9;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by anujjamwal on 13/07/17.
 */
public class TypeDefinitionTest {
    @Test
    public void shouldBuildDefinitionWithSingleType() {
        TypeDefinition typeDef = TypeDefinition.build("X");

        List<Pair<DataType, Integer>> spec = typeDef.getTypeDef();
        assertThat(spec.size(), is(1));
        assertThat(spec.get(0)._1, is(X));
        assertThat(spec.get(0)._2, is(1));
    }

    @Test
    public void shouldBuildDefinitionWithSingleTypeWithExplicitCount() {
        TypeDefinition typeDef = TypeDefinition.build("X(1)");

        List<Pair<DataType, Integer>> spec = typeDef.getTypeDef();
        assertThat(spec.size(), is(1));
        assertThat(spec.get(0)._1, is(X));
        assertThat(spec.get(0)._2, is(1));
    }

    @Test
    public void shouldBuildDefinitionWithMultipleSingleType() {
        TypeDefinition typeDef = TypeDefinition.build("XXXXXXX");

        List<Pair<DataType, Integer>> spec = typeDef.getTypeDef();
        assertThat(spec.size(), is(1));
        assertThat(spec.get(0)._1, is(X));
        assertThat(spec.get(0)._2, is(7));
    }


    @Test
    public void shouldBuildDefinitionWithMultipleSingleTypeWithExplicitCount() {
        TypeDefinition typeDef = TypeDefinition.build("X(7)");

        List<Pair<DataType, Integer>> spec = typeDef.getTypeDef();
        assertThat(spec.size(), is(1));
        assertThat(spec.get(0)._1, is(X));
        assertThat(spec.get(0)._2, is(7));
    }

    @Test
    public void shouldBuildDefinitionWithMultipleTypes() {
        TypeDefinition typeDef = TypeDefinition.build("9999X999");

        List<Pair<DataType, Integer>> spec = typeDef.getTypeDef();
        assertThat(spec.size(), is(3));
        assertThat(spec.get(0)._1, is(_9));
        assertThat(spec.get(0)._2, is(4));
        assertThat(spec.get(1)._1, is(X));
        assertThat(spec.get(1)._2, is(1));
        assertThat(spec.get(2)._1, is(_9));
        assertThat(spec.get(2)._2, is(3));
    }

    @Test
    public void shouldBuildDefinitionWithMultipleTypesWithExplicitCount() {
        TypeDefinition typeDef = TypeDefinition.build("9(4)X(1)9(3)");

        List<Pair<DataType, Integer>> spec = typeDef.getTypeDef();
        assertThat(spec.size(), is(3));
        assertThat(spec.get(0)._1, is(_9));
        assertThat(spec.get(0)._2, is(4));
        assertThat(spec.get(1)._1, is(X));
        assertThat(spec.get(1)._2, is(1));
        assertThat(spec.get(2)._1, is(_9));
        assertThat(spec.get(2)._2, is(3));
    }

    @Test
    public void shouldBuildDefinitionWithMultipleTypesWithPartialExplicitCount() {
        TypeDefinition typeDef = TypeDefinition.build("9(4)X9(3)");

        List<Pair<DataType, Integer>> spec = typeDef.getTypeDef();
        assertThat(spec.size(), is(3));
        assertThat(spec.get(0)._1, is(_9));
        assertThat(spec.get(0)._2, is(4));
        assertThat(spec.get(1)._1, is(X));
        assertThat(spec.get(1)._2, is(1));
        assertThat(spec.get(2)._1, is(_9));
        assertThat(spec.get(2)._2, is(3));
    }

    @Test
    public void shouldBuildDefinitionWithMultipleTypesSingleLast() {
        TypeDefinition typeDef = TypeDefinition.build("9999X999X");

        List<Pair<DataType, Integer>> spec = typeDef.getTypeDef();
        assertThat(spec.size(), is(4));
        assertThat(spec.get(0)._1, is(_9));
        assertThat(spec.get(0)._2, is(4));
        assertThat(spec.get(1)._1, is(X));
        assertThat(spec.get(1)._2, is(1));
        assertThat(spec.get(2)._1, is(_9));
        assertThat(spec.get(2)._2, is(3));
        assertThat(spec.get(3)._1, is(X));
        assertThat(spec.get(3)._2, is(1));
    }

    @Test
    public void shouldBuildDefinitionWithMultipleTypesSingleLastWithExplicitCounts() {
        TypeDefinition typeDef = TypeDefinition.build("9(4)X(1)9(3)X(1)");

        List<Pair<DataType, Integer>> spec = typeDef.getTypeDef();
        assertThat(spec.size(), is(4));
        assertThat(spec.get(0)._1, is(_9));
        assertThat(spec.get(0)._2, is(4));
        assertThat(spec.get(1)._1, is(X));
        assertThat(spec.get(1)._2, is(1));
        assertThat(spec.get(2)._1, is(_9));
        assertThat(spec.get(2)._2, is(3));
        assertThat(spec.get(3)._1, is(X));
        assertThat(spec.get(3)._2, is(1));
    }

    @Test
    public void shouldBuildDefinitionWithMultipleTypesSingleLastWithPartialExplicitCounts() {
        TypeDefinition typeDef = TypeDefinition.build("9(4)X9(3)X");

        List<Pair<DataType, Integer>> spec = typeDef.getTypeDef();
        assertThat(spec.size(), is(4));
        assertThat(spec.get(0)._1, is(_9));
        assertThat(spec.get(0)._2, is(4));
        assertThat(spec.get(1)._1, is(X));
        assertThat(spec.get(1)._2, is(1));
        assertThat(spec.get(2)._1, is(_9));
        assertThat(spec.get(2)._2, is(3));
        assertThat(spec.get(3)._1, is(X));
        assertThat(spec.get(3)._2, is(1));
    }
}
