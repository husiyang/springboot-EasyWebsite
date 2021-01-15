package com.threegorges.demo.config;

//@Configuration
//@EnableCaching
//public class CacheConfig {
//
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
//        RedisCacheManager redisCacheManager =
//                RedisCacheManager.builder(redisConnectionFactory)
//                        .cacheDefaults(defaultCacheConfig(10000))
//                        .withInitialCacheConfigurations(initCacheConfigMap())
//                        .transactionAware()
//                        .build();
//        return redisCacheManager;
//    }
//
//    private RedisCacheConfiguration defaultCacheConfig(Integer second){
//        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        serializer.setObjectMapper(mapper);
//
//        RedisCacheConfiguration config =
//                RedisCacheConfiguration.defaultCacheConfig()
//                        .entryTtl(Duration.ofSeconds(second))
//                        .serializeKeysWith(RedisSerializationContext
//                                .SerializationPair
//                                .fromSerializer(new StringRedisSerializer()))
//                        .serializeValuesWith(
//                                RedisSerializationContext
//                                        .SerializationPair
//                                        .fromSerializer(serializer))
//                        .disableCachingNullValues();
//        return config;
//    }
//
//    private Map<String, RedisCacheConfiguration> initCacheConfigMap(){
//        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
//        configMap.put("employee",this.defaultCacheConfig(1000));
//        return configMap;
//    }
//}
