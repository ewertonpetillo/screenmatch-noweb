package br.com.ewerton.screenmatch.services;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe); //Transforma o JSON na classe indicada
}
